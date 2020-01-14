package com.neteasy.manager.modules.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.common.utils.date.DateStyle;
import com.neteasy.common.utils.date.DateUtils;
import com.neteasy.common.utils.string.StringUtils;
import com.neteasy.manager.modules.activity.entity.ActivityDetailImageEntity;
import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.neteasy.manager.modules.activity.dao.ActivityMapper;
import com.neteasy.manager.modules.activity.entity.ActivityFormItemEntity;
import com.neteasy.manager.modules.activity.entity.ActivityFormItemOptionEntity;
import com.neteasy.manager.modules.activity.form.AddActivityForm;
import com.neteasy.manager.modules.activity.form.FormItemForm;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.service.ActivityDetailImageService;
import com.neteasy.manager.modules.activity.service.ActivityFormItemOptionService;
import com.neteasy.manager.modules.activity.service.ActivityFormItemService;
import com.neteasy.manager.modules.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.activity.vo.ActivityInfoVO;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import com.neteasy.manager.modules.activity.vo.FormItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @since 2020-01-12
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, ActivityEntity> implements ActivityService {

    @Autowired
    ActivityDetailImageService activityDetailImageService;
    @Autowired
    ActivityFormItemService activityFormItemService;
    @Autowired
    ActivityFormItemOptionService activityFormItemOptionService;

    @Override
    public PageInfo<ActivityListItemVO> listActivity(SearchActivityListForm form) {
        return PageHelper.startPage(form.getPage().getPage(),
                form.getPage().getLimit()).doSelectPageInfo(() -> {
            baseMapper.listActivity(form.getTitle(), form.getBusinessId(), form.getJmRegionId());
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addActivity(AddActivityForm form, SysUserEntity sysUserEntity) {
        Date now = new Date();

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setBusinessId(form.getBusinessId());
        activityEntity.setTitle(form.getTitle());
        activityEntity.setMainImage(form.getMainImage());
        activityEntity.setBanner(form.getBanner());
        activityEntity.setActivityStartTime(DateUtils.stringToDate(form.getActivityStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityEntity.setActivityEndTime(DateUtils.stringToDate(form.getActivityEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityEntity.setEnrollStartTime(DateUtils.stringToDate(form.getEnrollStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityEntity.setEnrollEndTime(DateUtils.stringToDate(form.getEnrollEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityEntity.setJmRegionId(form.getJmRegionId());
        activityEntity.setAddress(StringUtils.isNotEmpty(form.getAddress()) ? form.getAddress() : null);
        activityEntity.setPhone(StringUtils.isNotEmpty(form.getPhone()) ? form.getPhone() : null);
        activityEntity.setState(1);
        activityEntity.setDeleted(0);
        activityEntity.setSysUserId(sysUserEntity.getId());
        activityEntity.setCreateTime(now);
        save(activityEntity);

        for (String imageUrl : form.getDetailImage()) {
            ActivityDetailImageEntity imageEntity = new ActivityDetailImageEntity();
            imageEntity.setActivityId(activityEntity.getId());
            imageEntity.setImageUrl(imageUrl);
            imageEntity.setCreateTime(now);
            activityDetailImageService.save(imageEntity);
        }

        int seq = 1;
        for (FormItemForm itemForm : form.getFormItems()) {
            ActivityFormItemEntity itemEntity = new ActivityFormItemEntity();
            itemEntity.setActivityId(activityEntity.getId());
            itemEntity.setLabel(itemForm.getLabel());
            itemEntity.setMust(itemForm.getMust());
            itemEntity.setType(itemForm.getType());
            itemEntity.setSeq(seq);
            itemEntity.setCreateTime(now);
            activityFormItemService.save(itemEntity);

            if (itemForm.getOptions() != null) {
                for (String option : itemForm.getOptions()) {
                    ActivityFormItemOptionEntity optionEntity = new ActivityFormItemOptionEntity();
                    optionEntity.setFormItemId(itemEntity.getId());
                    optionEntity.setOptionValue(option);
                    optionEntity.setCreateTime(now);
                    activityFormItemOptionService.save(optionEntity);
                }
            }

            seq++;
        }
    }

    @Override
    public ActivityInfoVO getActivityInfo(Long activityId) {
        // 获取活动表单
        List<ActivityFormItemEntity> formItemEntities = activityFormItemService
                .list(new QueryWrapper<ActivityFormItemEntity>()
                        .eq("activity_id", activityId)
                        .orderByAsc("seq"));
        List<FormItemVO> formItems = new ArrayList<>();
        for (ActivityFormItemEntity formItemEntity : formItemEntities) {
            FormItemVO itemVO = new FormItemVO();
            itemVO.setMust(formItemEntity.getMust());
            itemVO.setType(formItemEntity.getType());
            itemVO.setLabel(formItemEntity.getLabel());
            if (formItemEntity.getType() != 1) {
                List<ActivityFormItemOptionEntity> itemOptionEntities = activityFormItemOptionService
                        .list(new QueryWrapper<ActivityFormItemOptionEntity>()
                                .eq("form_item_id", formItemEntity.getId()));
                List<String> collect = itemOptionEntities.stream().map(ActivityFormItemOptionEntity::getOptionValue).collect(Collectors.toList());
                StringBuilder options = new StringBuilder();
                for (String s : collect) {
                    options.append(s).append("|");
                }
                options.deleteCharAt(options.length() - 1);
                itemVO.setOptions(options.toString());
            }
            formItems.add(itemVO);
        }

        // 获取详情图片
        List<ActivityDetailImageEntity> detailImageEntities = activityDetailImageService
                .list(new QueryWrapper<ActivityDetailImageEntity>()
                        .eq("activity_id", activityId));
        List<String> detailImages = detailImageEntities.stream().map(ActivityDetailImageEntity::getImageUrl).collect(Collectors.toList());

        // 获取活动信息
        ActivityEntity activityEntity = getById(activityId);
        ActivityInfoVO activityInfoVO = new ActivityInfoVO();
        activityInfoVO.setId(activityId);
        activityInfoVO.setBusinessId(activityEntity.getBusinessId());
        activityInfoVO.setTitle(activityEntity.getTitle());
        activityInfoVO.setMainImage(activityEntity.getMainImage());
        activityInfoVO.setBanner(activityEntity.getBanner());
        activityInfoVO.setActivityStartTime(DateUtils.dateToString(activityEntity.getActivityStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityInfoVO.setActivityEndTime(DateUtils.dateToString(activityEntity.getActivityEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityInfoVO.setEnrollStartTime(DateUtils.dateToString(activityEntity.getEnrollStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityInfoVO.setEnrollEndTime(DateUtils.dateToString(activityEntity.getEnrollEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        activityInfoVO.setJmRegionId(activityEntity.getJmRegionId());
        activityInfoVO.setAddress(activityEntity.getAddress());
        activityInfoVO.setPhone(activityEntity.getPhone());
        activityInfoVO.setDetailImage(detailImages);
        activityInfoVO.setFormItems(formItems);
        return activityInfoVO;
    }
}
