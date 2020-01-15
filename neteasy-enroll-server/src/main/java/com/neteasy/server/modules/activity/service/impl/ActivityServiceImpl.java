package com.neteasy.server.modules.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.common.utils.date.DateStyle;
import com.neteasy.common.utils.date.DateUtils;
import com.neteasy.server.modules.activity.entity.*;
import com.neteasy.server.modules.activity.dao.ActivityMapper;
import com.neteasy.server.modules.activity.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.server.modules.activity.vo.ActivityFormItemVO;
import com.neteasy.server.modules.activity.vo.ActivityInfoVO;
import com.neteasy.server.modules.activity.vo.ActivityInfoViewVO;
import com.neteasy.server.modules.activity.vo.PreActivityVO;
import com.neteasy.server.modules.business.service.BusinessService;
import com.neteasy.server.modules.enroll.entity.UserEnrollEntity;
import com.neteasy.server.modules.enroll.service.UserEnrollService;
import com.neteasy.server.modules.user.entity.UserCollectActivityEntity;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.modules.user.service.UserCollectActivityService;
import com.neteasy.server.web.exception.BaseException;
import com.neteasy.server.web.exception.message.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 活动表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, ActivityEntity> implements ActivityService {

    @Autowired
    ActivityDetailImageService activityDetailImageService;
    @Autowired
    UserEnrollService userEnrollService;
    @Autowired
    BusinessService businessService;
    @Autowired
    UserCollectActivityService userCollectActivityService;
    @Autowired
    ActivityFormItemService activityFormItemService;
    @Autowired
    ActivityFormItemOptionService activityFormItemOptionService;
    @Autowired
    ActivityViewLogService activityViewLogService;

    @Override
    public List<PreActivityVO> listBusinessActivity(Long businessId) {
        List<PreActivityVO> preActivityVOS = baseMapper.listBusinessActivity(businessId);
        preActivityVOS.forEach(item -> {
            Date activityTime = DateUtils.stringToDate(item.getDate(), DateStyle.YYYY_MM_DD_HH_MM_SS);
            String date = DateUtils.dateToString(activityTime, "MM/dd");
            String dayOfWeek = DateUtils.getDayOfWeekStr2(activityTime);
            item.setDate(date + "(" + dayOfWeek + ")");
        });
        return preActivityVOS;
    }

    @Override
    public List<PreActivityVO> listActivity(Integer enrollState, Long jmRegionId) {
        List<PreActivityVO> preActivityVOS = baseMapper.listActivity(jmRegionId, enrollState);
        preActivityVOS.forEach(item -> {
            Date activityTime = DateUtils.stringToDate(item.getDate(), DateStyle.YYYY_MM_DD_HH_MM_SS);
            String date = DateUtils.dateToString(activityTime, "MM/dd");
            String dayOfWeek = DateUtils.getDayOfWeekStr2(activityTime);
            item.setDate(date + "(" + dayOfWeek + ")");
        });
        return preActivityVOS;
    }

    @Override
    public ActivityInfoViewVO getActivityInfo(Long activityId, UserEntity userEntity) {

        // 获取活动实体
        ActivityEntity activityEntity = getById(activityId);
        if (activityEntity.getDeleted() == 1 || activityEntity.getState() == 0) {
            throw new BaseException(ErrorInfo.ACTIVITY_DELETED);
        }

        // 获取活动详情图
        List<ActivityDetailImageEntity> detailImageEntityList = activityDetailImageService
                .list(new QueryWrapper<ActivityDetailImageEntity>().eq("activity_id", activityId));
        List<String> collect = detailImageEntityList.stream().map(ActivityDetailImageEntity::getImageUrl).collect(Collectors.toList());

        // 获取报名人数
        int enrollNum = userEnrollService.count(new QueryWrapper<UserEnrollEntity>().eq("activity_id", activityId));

        // 获取浏览人数
        int viewNum = activityViewLogService.count(new QueryWrapper<ActivityViewLogEntity>()
                .eq("activity_id", activityEntity.getId()));
        try {
            ActivityViewLogEntity logEntity = new ActivityViewLogEntity();
            logEntity.setUserId(userEntity == null ? null : userEntity.getId());
            logEntity.setActivityId(activityId);
            logEntity.setCreateTime(new Date());
            activityViewLogService.save(logEntity);
        } catch (Exception e) {
            System.out.println(e);
        }

        // 计算报名状态
        Date now = new Date();
        Integer enrollState;
        String enrollStateStr;
        if (activityEntity.getEnrollStartTime().getTime() > now.getTime()) {
            enrollState = 1;
            enrollStateStr = "尚未开始";
        } else if (activityEntity.getEnrollStartTime().getTime() <= now.getTime() &&
                activityEntity.getEnrollEndTime().getTime() > now.getTime()) {
            enrollState = 2;
            enrollStateStr = "报名中";
        } else {
            enrollState = 3;
            enrollStateStr = "报名结束";
        }

        // 格式化活动时间
        String activityTime;
        if (activityEntity.getActivityStartTime().getTime() == activityEntity.getActivityEndTime().getTime()) {
            activityTime = DateUtils.dateToString(activityEntity.getActivityStartTime(), "MM/dd HH:mm");
        } else {
            activityTime = DateUtils.dateToString(activityEntity.getActivityStartTime(), "MM/dd HH:mm") + " - " +
                    DateUtils.dateToString(activityEntity.getActivityEndTime(), "MM/dd HH:mm");
        }

        // 格式化报名时间
        String enrollStartTime = DateUtils.dateToString(activityEntity.getEnrollStartTime(), "MM/dd HH:mm");
        String enrollEndTime = DateUtils.dateToString(activityEntity.getEnrollEndTime(), "MM/dd HH:mm");

        // 检查当前用户是否报名
        Integer isEnroll = 0;
        if (userEntity != null) {
            UserEnrollEntity userEnrollEntity = userEnrollService.getOne(new QueryWrapper<UserEnrollEntity>()
                    .eq("activity_id", activityId)
                    .eq("user_id", userEntity.getId()));
            if (userEnrollEntity != null) {
                isEnroll = 1;
            }
        }

        // 检查是否已经收藏
        Integer isCollect = 0;
        if (userEntity != null) {
            UserCollectActivityEntity userCollectActivityEntity = userCollectActivityService
                    .getOne(new QueryWrapper<UserCollectActivityEntity>()
                            .eq("activity_id", activityId)
                            .eq("user_id", userEntity.getId()));
            if (userCollectActivityEntity != null) {
                isCollect = 1;
            }
        }


        ActivityInfoVO infoVO = new ActivityInfoVO();
        infoVO.setActivityId(activityId);
        infoVO.setBanner(activityEntity.getBanner());
        infoVO.setTitle(activityEntity.getTitle());
        infoVO.setEnrollNum(enrollNum);
        infoVO.setActivityState(enrollState);
        infoVO.setActivityStateStr(enrollStateStr);
        infoVO.setActivityTime(activityTime);
        infoVO.setStartTime(enrollStartTime);
        infoVO.setEndTime(enrollEndTime);
        infoVO.setAddress(activityEntity.getAddress());
        infoVO.setPhone(activityEntity.getPhone());
        infoVO.setIsEnroll(isEnroll);
        infoVO.setActivityDetail(collect);
        infoVO.setIsCollect(isCollect);
        infoVO.setViewNum(viewNum + 1);

        ActivityInfoViewVO vo = new ActivityInfoViewVO();
        vo.setActivityInfo(infoVO);
        vo.setBusiness(businessService.getPreBusiness(activityEntity.getBusinessId()));

        return vo;
    }

    @Override
    public void collectOrRemove(Long activityId, UserEntity userEntity) {
        UserCollectActivityEntity userCollectActivityEntity = userCollectActivityService
                .getOne(new QueryWrapper<UserCollectActivityEntity>()
                        .eq("activity_id", activityId)
                        .eq("user_id", userEntity.getId()));
        if (userCollectActivityEntity == null) {
            userCollectActivityEntity = new UserCollectActivityEntity();
            userCollectActivityEntity.setActivityId(activityId);
            userCollectActivityEntity.setUserId(userEntity.getId());
            userCollectActivityEntity.setCreateTime(new Date());
            userCollectActivityService.save(userCollectActivityEntity);
        } else {
            userCollectActivityService.removeById(userCollectActivityEntity.getId());
        }
    }

    @Override
    public List<ActivityFormItemVO> listActivityFormItem(Long activityId) {
        List<ActivityFormItemEntity> formItemEntities = activityFormItemService
                .list(new QueryWrapper<ActivityFormItemEntity>()
                        .eq("activity_id", activityId)
                        .orderByAsc("seq"));

        List<ActivityFormItemVO> list = new ArrayList<>();
        for (ActivityFormItemEntity formItemEntity : formItemEntities) {
            ActivityFormItemVO itemVO = new ActivityFormItemVO();
            itemVO.setFormItemId(formItemEntity.getId());
            itemVO.setType(formItemEntity.getType());
            itemVO.setLabel(formItemEntity.getLabel());
            itemVO.setMust(formItemEntity.getMust());

            if (itemVO.getType() != 1) {
                List<ActivityFormItemOptionEntity> itemOptionEntities = activityFormItemOptionService.list(
                        new QueryWrapper<ActivityFormItemOptionEntity>()
                                .eq("form_item_id", formItemEntity.getId()));
                List<String> collect = itemOptionEntities.stream()
                        .map(ActivityFormItemOptionEntity::getOptionValue).collect(Collectors.toList());
                itemVO.setOptions(collect);
            }

            list.add(itemVO);
        }
        return list;
    }

    @Override
    public List<PreActivityVO> listIndexActivity() {
        return baseMapper.listIndexActivity();
    }

    @Override
    public List<PreActivityVO> listUserCollect(UserEntity userEntity) {
        return baseMapper.listUserCollect(userEntity.getId());
    }
}
