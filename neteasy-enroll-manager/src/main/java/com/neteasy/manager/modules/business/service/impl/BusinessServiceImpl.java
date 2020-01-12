package com.neteasy.manager.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.neteasy.manager.modules.activity.service.ActivityService;
import com.neteasy.manager.modules.business.entity.BusinessEntity;
import com.neteasy.manager.modules.business.dao.BusinessMapper;
import com.neteasy.manager.modules.business.form.AddOrUpdateBusinessForm;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商家表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-11
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, BusinessEntity> implements BusinessService {

    @Autowired
    ActivityService activityService;

    @Override
    public PageInfo<BusinessListItemVO> listBusiness(ListBusinessForm form) {
        return PageHelper.startPage(form.getPage().getPage(), form.getPage().getLimit())
                .doSelectPageInfo(() -> {
                    baseMapper.listBusiness(form.getBusinessName());
                });
    }

    @Override
    public void addBusiness(AddOrUpdateBusinessForm form, SysUserEntity sysUserEntity) {
        BusinessEntity entity = new BusinessEntity();
        entity.setBusinessName(form.getBusinessName());
        entity.setBusinessAbout(form.getBusinessAbout());
        entity.setLogo(form.getBusinessLogo());
        entity.setDeleted(0);
        entity.setSysUserId(sysUserEntity.getId());
        entity.setCreateTime(new Date());
        save(entity);
    }

    @Override
    public void editBusiness(AddOrUpdateBusinessForm form) {
        BusinessEntity entity = getById(form.getBusinessId());
        entity.setBusinessName(form.getBusinessName());
        entity.setBusinessAbout(form.getBusinessAbout());
        entity.setLogo(form.getBusinessLogo());
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeBusiness(Long businessId) {
        BusinessEntity businessEntity = getById(businessId);
        businessEntity.setDeleted(1);
        updateById(businessEntity);

        List<ActivityEntity> activityEntities = activityService
                .list(new QueryWrapper<ActivityEntity>()
                        .eq("business_id", businessId));
        for (ActivityEntity activityEntity : activityEntities) {
            activityEntity.setDeleted(1);
            activityService.updateById(activityEntity);
        }
    }
}
