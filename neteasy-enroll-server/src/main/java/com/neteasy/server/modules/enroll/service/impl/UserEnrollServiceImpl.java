package com.neteasy.server.modules.enroll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.common.utils.date.DateStyle;
import com.neteasy.common.utils.date.DateUtils;
import com.neteasy.common.utils.random.RandomUtils;
import com.neteasy.server.modules.activity.entity.ActivityCheckUserEntity;
import com.neteasy.server.modules.activity.entity.ActivityEntity;
import com.neteasy.server.modules.activity.entity.ActivityFormItemEntity;
import com.neteasy.server.modules.activity.service.ActivityCheckUserService;
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
import com.neteasy.server.modules.enroll.vo.CheckCodeInfoVO;
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
    @Autowired
    ActivityCheckUserService activityCheckUserService;

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
        userEnrollEntity.setCheckCode(RandomUtils.genRandomNumber(10));
        userEnrollEntity.setCheckState(0);
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

        // 如果用户已核销，不能取消报名
        if (userEnrollEntity.getCheckState() == 1) {
            throw new BaseException(ErrorInfo.ENROLL_ALREADY_CHECK);
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

    @Override
    public CheckCodeInfoVO getCheckCodeInfo(Long enrollId) {
        UserEnrollEntity userEnrollEntity = getById(enrollId);
        ActivityEntity activityEntity = activityService.getById(userEnrollEntity.getActivityId());
        BusinessEntity businessEntity = businessService.getById(activityEntity.getBusinessId());

        CheckCodeInfoVO checkCodeInfoVO = new CheckCodeInfoVO();
        checkCodeInfoVO.setBusinessLogo(businessEntity.getLogo());
        checkCodeInfoVO.setActivityTitle(activityEntity.getTitle());
        checkCodeInfoVO.setCheckCode(userEnrollEntity.getCheckCode());
        checkCodeInfoVO.setCheckCodePart1(userEnrollEntity.getCheckCode().substring(0, 3));
        checkCodeInfoVO.setCheckCodePart2(userEnrollEntity.getCheckCode().substring(3, 6));
        checkCodeInfoVO.setCheckCodePart3(userEnrollEntity.getCheckCode().substring(6));
        checkCodeInfoVO.setCheckState(userEnrollEntity.getCheckState());
        checkCodeInfoVO.setCheckTime(userEnrollEntity.getCheckTime() == null ?
                null : DateUtils.dateToString(userEnrollEntity.getCheckTime(), DateStyle.YYYY_MM_DD_HH_MM));
        return checkCodeInfoVO;
    }

    @Override
    public UserEnrollInfoVO checkUserEnroll(String checkCode, UserEntity userEntity) {
        // 获取用户报名
        UserEnrollEntity userEnrollEntity = this.getOne(
                new QueryWrapper<UserEnrollEntity>().eq("check_code", checkCode));
        if (userEnrollEntity == null) {
            throw new BaseException(ErrorInfo.CHECK_CODE_NOT_EXIST);
        }
        if (userEnrollEntity.getCheckState() == 1) {
            throw new BaseException(ErrorInfo.CHECK_CODE_ALREADY_CHECK);
        }

        // 检查是否活动核销人
        ActivityCheckUserEntity checkUserEntity = activityCheckUserService.getOne(
                new QueryWrapper<ActivityCheckUserEntity>()
                        .eq("activity_id", userEnrollEntity.getActivityId())
                        .eq("user_id", userEntity.getId()));
        if (checkUserEntity == null) {
            throw new BaseException(ErrorInfo.NOT_CHECK_USER);
        }

        // 改变核销状态
        userEnrollEntity.setCheckState(1);
        userEnrollEntity.setCheckType(1);
        userEnrollEntity.setCheckTime(new Date());
        userEnrollEntity.setCheckUserId(userEntity.getId());
        this.updateById(userEnrollEntity);

        return this.getUserEnrollInfo(userEnrollEntity.getId());
    }
}
