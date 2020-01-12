package com.neteasy.manager.modules.activity.service.impl;

import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.neteasy.manager.modules.activity.dao.ActivityMapper;
import com.neteasy.manager.modules.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-12
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, ActivityEntity> implements ActivityService {

}
