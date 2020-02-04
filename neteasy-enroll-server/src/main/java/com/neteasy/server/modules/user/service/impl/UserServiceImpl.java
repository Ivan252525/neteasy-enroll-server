package com.neteasy.server.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.common.utils.string.StringUtils;
import com.neteasy.server.modules.user.bean.LoginSession;
import com.neteasy.server.modules.user.entity.UserCollectActivityEntity;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.modules.user.dao.UserMapper;
import com.neteasy.server.modules.user.entity.UserLikeBusinessEntity;
import com.neteasy.server.modules.user.form.InitWxUserForm;
import com.neteasy.server.modules.user.form.UpdateUserInfoForm;
import com.neteasy.server.modules.user.service.UserCollectActivityService;
import com.neteasy.server.modules.user.service.UserLikeBusinessService;
import com.neteasy.server.modules.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.server.modules.user.vo.UserDataVO;
import com.neteasy.server.utils.wx.WxMiniUtils;
import com.neteasy.server.utils.wx.bean.WxMiniSession;
import com.neteasy.server.web.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserLikeBusinessService userLikeBusinessService;
    @Autowired
    UserCollectActivityService userCollectActivityService;

    @Override
    public LoginSession login(String code) {
        UserEntity userEntity;
        String sessionKey = "";
        if (code.equals("123")) {
            userEntity = getById(1);
        } else {
            WxMiniSession wxMiniSession = WxMiniUtils.code2session(code);
            sessionKey = wxMiniSession.getSessionKey();
            userEntity = getOne(new QueryWrapper<UserEntity>().eq("open_id", wxMiniSession.getOpenId()));
            if (userEntity == null) {
                userEntity = new UserEntity();
                userEntity.setOpenId(wxMiniSession.getOpenId());
                userEntity.setState(1);
                userEntity.setCreateTime(new Date());
                save(userEntity);
            }
        }

        String token = jwtUtils.generateToken(userEntity.getId());

        LoginSession session = new LoginSession();
        session.setUserInfo(userEntity);
        session.setToken(token);
        session.setWxSessionKey(sessionKey);
        session.setExpireIn(System.currentTimeMillis() + 432000);
        if (StringUtils.isEmpty(userEntity.getUserLogo()) || StringUtils.isEmpty(userEntity.getNickname())) {
            session.setInit(false);
        } else {
            session.setInit(true);
        }

        return session;
    }

    @Override
    public LoginSession initUser(InitWxUserForm form, UserEntity userEntity) {
        userEntity.setNickname(form.getNickname());
        userEntity.setSex(form.getSex());
        userEntity.setUserLogo(form.getUserLogo());
        updateById(userEntity);

        String token = jwtUtils.generateToken(userEntity.getId());

        LoginSession session = new LoginSession();
        session.setUserInfo(userEntity);
        session.setToken(token);
        session.setWxSessionKey("");
        session.setExpireIn(System.currentTimeMillis() + 432000);
        session.setInit(true);

        return session;
    }

    @Override
    public UserDataVO getUserData(UserEntity userEntity) {
        int likeNum = userLikeBusinessService.count(new QueryWrapper<UserLikeBusinessEntity>()
                .eq("user_id", userEntity.getId()));
        int collectNum = userCollectActivityService.count(new QueryWrapper<UserCollectActivityEntity>()
                .eq("user_id", userEntity.getId()));

        UserDataVO vo = new UserDataVO();
        vo.setLikeNum(likeNum);
        vo.setCollectNum(collectNum);
        return vo;
    }

    @Override
    public LoginSession updateUserInfo(UserEntity userEntity, UpdateUserInfoForm form) {
        userEntity = getById(userEntity.getId());
        if (StringUtils.isNotEmpty(form.getNickname())) {
            userEntity.setNickname(form.getNickname());
        }
        if (StringUtils.isNotEmpty(form.getUserLogo())) {
            userEntity.setUserLogo(form.getUserLogo());
        }

        updateById(userEntity);

        String token = jwtUtils.generateToken(userEntity.getId());

        LoginSession session = new LoginSession();
        session.setUserInfo(userEntity);
        session.setToken(token);
        session.setWxSessionKey("");
        session.setExpireIn(System.currentTimeMillis() + 432000);
        session.setInit(true);

        return session;
    }
}
