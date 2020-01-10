package com.neteasy.server.modules.user.service;

import com.neteasy.server.modules.user.bean.LoginSession;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.server.modules.user.form.InitWxUserForm;
import com.neteasy.server.modules.user.vo.UserDataVO;

/**
 * <p>
 * 用户表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-07
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 根据小程序登陆的code进行登陆
     *
     * @param code
     * @return
     */
    LoginSession login(String code);

    /**
     * 初始化用户
     *
     * @param form
     * @param userEntity
     * @return
     */
    LoginSession initUser(InitWxUserForm form, UserEntity userEntity);

    /**
     * 获取用户数据
     *
     * @param userEntity
     * @return
     */
    UserDataVO getUserData(UserEntity userEntity);

}
