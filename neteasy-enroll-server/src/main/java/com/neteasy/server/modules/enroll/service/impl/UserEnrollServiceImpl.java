package com.neteasy.server.modules.enroll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.common.utils.date.DateStyle;
import com.neteasy.common.utils.date.DateUtils;
import com.neteasy.server.modules.activity.entity.ActivityEntity;
import com.neteasy.server.modules.activity.entity.ActivityFormItemEntity;
import com.neteasy.server.modules.activity.service.ActivityFormItemService;
import com.neteasy.server.modules.activity.service.ActivityService;
import com.neteasy.server.modules.business.entity.BusinessEntity;
import com.neteasy.server.modules.business.service.BusinessService;
import com.neteasy.server.modules.enroll.entity.UserCancelEnrollEntity;
import com.neteasy.server.modules.enroll.entity.UserEnrollEntity;
import com.neteasy.server.modules.enroll.dao.UserEnrollMapper;
import com.neteasy.server.modules.enroll.entity.UserEnrollInputEntity;
import com.neteasy.server.modules.enroll.form.CancelEnrollForm;
import com.neteasy.server.modules.enroll.form.EnrollForm;
import com.neteasy.server.modules.enroll.form.EnrollFormItem;
import com.neteasy.server.modules.enroll.service.UserCancelEnrollService;
import com.neteasy.server.modules.enroll.service.UserEnrollInputService;
import com.neteasy.server.modules.enroll.service.UserEnrollService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.server.modules.enroll.vo.PreUserEnroll;
import com.neteasy.server.modules.enroll.vo.UserEnrollInfoVO;
import com.neteasy.server.modules.enroll.vo.UserEnrollInfoVOItem;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.web.exception.BaseException;
import com.neteasy.server.web.exception.message.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户报名表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
@Service
public class UserEnrollServiceImpl extends ServiceImpl<UserEnrollMapper, UserEnrollEntity> implements UserEnrollService {

    @Autowired
    UserEnrollInputService userEnrollInputService;
    @Autowired
    ActivityService activityService;
    @Autowired
    BusinessService businessService;
    @Autowired
    ActivityFormItemService activityFormItemService;
    @Autowired
    UserCancelEnrollService userCancelEnrollService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userEnroll(EnrollForm form, UserEntity userEntity) {
        // 检查是否已经报名
        UserEnrollEntity userEnrollEntity = getOne(new QueryWrapper<UserEnrollEntity>()
                .eq("user_id", userEntity.getId())
                .eq("activity_id", form.getActivityId()));
        if (userEnrollEntity != null) {
            throw new BaseException(ErrorInfo.USER_ALREADY_ENROLL);
        }

        // 添加用户报名记录
        userEnrollEntity = new UserEnrollEntity();
        userEnrollEntity.setUserId(userEntity.getId());
        userEnrollEntity.setActivityId(form.getActivityId());
        userEnrollEntity.setCreateTime(new Date());
        save(userEnrollEntity);

        // 添加用户报名信息
        Date now = new Date();
        for (EnrollFormItem formItem : form.getFormItems()) {
            UserEnrollInputEntity inputEntity =  new UserEnrollInputEntity();
            inputEntity.setActivityId(form.getActivityId());
            inputEntity.setUserId(userEntity.getId());
            inputEntity.setEnrollId(userEnrollEntity.getId());
            inputEntity.setFormItemId(formItem.getFormItemId());
            inputEntity.setInputValue(formItem.getValue());
            inputEntity.setCreateTime(now);
            userEnrollInputService.save(inputEntity);
        }
    }

    @Override
    public List<PreUserEnroll> listPreUserEnroll(Long userId) {
        List<PreUserEnroll> preUserEnrolls = baseMapper.listPreUserEnroll(userId);
        preUserEnrolls.forEach(item -> {
            Date activityTime = DateUtils.stringToDate(item.getDate(), DateStyle.YYYY_MM_DD_HH_MM_SS);
            String date = DateUtils.dateToString(activityTime, "MM/dd");
            String dayOfWeek = DateUtils.getDayOfWeekStr2(activityTime);
            item.setDate(date + "(" + dayOfWeek + ")");
        });
        return preUserEnrolls;
    }

    @Override
    public UserEnrollInfoVO getUserEnrollInfo(Long userEnrollId) {
        // 获取用户报名记录
        UserEnrollEntity userEnrollEntity = getById(userEnrollId);

        // 获取活动和商家实体
        ActivityEntity activityEntity = activityService.getById(userEnrollEntity.getActivityId());
        BusinessEntity businessEntity = businessService.getById(activityEntity.getBusinessId());

        // 获取报名表单
        List<ActivityFormItemEntity> formItemEntities = activityFormItemService
                .list(new QueryWrapper<ActivityFormItemEntity>()
                    .eq("activity_id", activityEntity.getId())
                    .orderByAsc("seq"));

        // 获取用户输入
        List<UserEnrollInputEntity> inputEntities = userEnrollInputService
                .list(new QueryWrapper<UserEnrollInputEntity>().eq("enroll_id", userEnrollId));

        List<UserEnrollInfoVOItem> infoVOItems = new ArrayList<>();
        for (ActivityFormItemEntity itemEntity : formItemEntities) {
            String value = "";
            for (UserEnrollInputEntity inputEntity : inputEntities) {
                if (inputEntity.getFormItemId().equals(itemEntity.getId())) {
                    value = inputEntity.getInputValue();
                    break;
                }
            }

            UserEnrollInfoVOItem infoVOItem = new UserEnrollInfoVOItem();
            infoVOItem.setLabel(itemEntity.getLabel());
            infoVOItem.setValue(value);
            infoVOItems.add(infoVOItem);
        }

        UserEnrollInfoVO vo = new UserEnrollInfoVO();
        vo.setActivityId(userEnrollEntity.getActivityId());
        vo.setUserEnrollId(userEnrollId);
        vo.setBusinessLogo(businessEntity.getLogo());
        vo.setInputItems(infoVOItems);
        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelEnroll(CancelEnrollForm form, UserEntity userEntity) {
        UserEnrollEntity userEnrollEntity = getById(form.getEnrollId());
        if (!userEnrollEntity.getUserId().equals(userEntity.getId())) {
            throw new BaseException(ErrorInfo.NETWORK_ERROR);
        }

        removeById(form.getEnrollId());

        userEnrollInputService.remove(new QueryWrapper<UserEnrollInputEntity>().eq("enroll_id", form.getEnrollId()));

        UserCancelEnrollEntity cancelEnrollEntity = new UserCancelEnrollEntity();
        cancelEnrollEntity.setActivityId(userEnrollEntity.getActivityId());
        cancelEnrollEntity.setCreateTime(new Date());
        cancelEnrollEntity.setEnrollTime(userEnrollEntity.getCreateTime());
        cancelEnrollEntity.setUserId(userEnrollEntity.getUserId());
        cancelEnrollEntity.setReason(form.getReason());
        userCancelEnrollService.save(cancelEnrollEntity);
    }
}
