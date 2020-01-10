package com.neteasy.manager.modules.sys.service;

import com.neteasy.manager.modules.sys.bean.LoginSession;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.sys.form.LoginForm;

/**
 * <p>
 * 系统管理员账号表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-10
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 登录
     *
     * @param form
     * @return
     */
    LoginSession login(LoginForm form);

}
