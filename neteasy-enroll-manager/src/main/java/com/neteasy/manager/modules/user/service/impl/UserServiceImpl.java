package com.neteasy.manager.modules.user.service.impl;

import com.neteasy.manager.modules.user.entity.UserEntity;
import com.neteasy.manager.modules.user.dao.UserMapper;
import com.neteasy.manager.modules.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-02-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
