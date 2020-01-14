package com.neteasy.manager.modules.enroll.service.impl;

import com.neteasy.manager.modules.enroll.entity.UserEnrollInputEntity;
import com.neteasy.manager.modules.enroll.dao.UserEnrollInputMapper;
import com.neteasy.manager.modules.enroll.service.UserEnrollInputService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户报名信息表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-14
 */
@Service
public class UserEnrollInputServiceImpl extends ServiceImpl<UserEnrollInputMapper, UserEnrollInputEntity> implements UserEnrollInputService {

    @Override
    public List<UserEnrollInputEntity> listWithSeq(Long userEnrollId) {
        return baseMapper.listWithOrder(userEnrollId);
    }
}
