package com.neteasy.server.modules.activity.service.impl;

import com.neteasy.server.modules.activity.entity.ActivityViewLogEntity;
import com.neteasy.server.modules.activity.dao.ActivityViewLogMapper;
import com.neteasy.server.modules.activity.service.ActivityViewLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动浏览记录表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
@Service
public class ActivityViewLogServiceImpl extends ServiceImpl<ActivityViewLogMapper, ActivityViewLogEntity> implements ActivityViewLogService {

}
