package com.neteasy.manager.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.common.utils.md5.MD5;
import com.neteasy.manager.modules.sys.bean.LoginSession;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import com.neteasy.manager.modules.sys.dao.SysUserMapper;
import com.neteasy.manager.modules.sys.form.LoginForm;
import com.neteasy.manager.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.web.exception.BaseException;
import com.neteasy.manager.web.exception.message.ErrorInfo;
import com.neteasy.manager.web.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统管理员账号表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public LoginSession login(LoginForm form) {
        String md5 = MD5.md5(form.getPassword()).toUpperCase();
        SysUserEntity sysUserEntity = getOne(new QueryWrapper<SysUserEntity>()
                .eq("username", form.getUsername())
                .eq("password", md5));
        if (sysUserEntity == null) {
            throw new BaseException(ErrorInfo.LOGIN_ERROR);
        }

        String token = jwtUtils.generateToken(sysUserEntity.getId());

        LoginSession session = new LoginSession();
        session.setToken(token);
        session.setUsername(sysUserEntity.getUsername());
        session.setExpireIn(System.currentTimeMillis() + 432000);
        return session;
    }
}
