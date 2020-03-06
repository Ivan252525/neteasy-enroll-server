package com.neteasy.server.modules.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.common.utils.date.DateStyle;
import com.neteasy.common.utils.date.DateUtils;
import com.neteasy.server.modules.activity.entity.ActivityCheckUserEntity;
import com.neteasy.server.modules.activity.dao.ActivityCheckUserMapper;
import com.neteasy.server.modules.activity.entity.ActivityEntity;
import com.neteasy.server.modules.activity.service.ActivityCheckUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.server.modules.activity.service.ActivityService;
import com.neteasy.server.modules.activity.vo.CheckActivityListItemVO;
import com.neteasy.server.modules.enroll.entity.UserEnrollEntity;
import com.neteasy.server.modules.enroll.service.UserEnrollService;
import com.neteasy.server.modules.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 活动核销人表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-02-27
 */
@Service
public class ActivityCheckUserServiceImpl extends ServiceImpl<ActivityCheckUserMapper, ActivityCheckUserEntity> implements ActivityCheckUserService {

    @Autowired
    ActivityService activityService;
    @Autowired
    UserEnrollService userEnrollService;

    @Override
    public List<CheckActivityListItemVO> listCheckActivity(UserEntity userEntity) {
        List<CheckActivityListItemVO> checkActivityListItemVOS = baseMapper.listCheckActivity(userEntity.getId());
        checkActivityListItemVOS.forEach(item -> {
            Date activityTime = DateUtils.stringToDate(item.getDate(), DateStyle.YYYY_MM_DD_HH_MM_SS);
            String date = DateUtils.dateToString(activityTime, "MM/dd");
            String dayOfWeek = DateUtils.getDayOfWeekStr2(activityTime);
            item.setDate(date + "(" + dayOfWeek + ")");

            // 查询报名人数
            int enrollCount = userEnrollService.count(new QueryWrapper<UserEnrollEntity>()
                    .eq("activity_id", item.getActivityId()));
            int checkCount = userEnrollService.count(new QueryWrapper<UserEnrollEntity>()
                    .eq("activity_id", item.getActivityId())
                    .eq("check_state", 1));

            item.setEnrollCount(enrollCount);
            item.setCheckCount(checkCount);
        });
        return checkActivityListItemVOS;
    }
}
