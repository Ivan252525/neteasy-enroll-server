package com.neteasy.manager.modules.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.business.entity.BusinessEntity;
import com.neteasy.manager.modules.business.dao.BusinessMapper;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import org.springframework.stereotype.Service;

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

    @Override
    public PageInfo<BusinessListItemVO> listBusiness(ListBusinessForm form) {
        return PageHelper.startPage(form.getPage().getPage(), form.getPage().getLimit())
                .doSelectPageInfo(() -> {
                    baseMapper.listBusiness(form.getBusinessName());
                });
    }
}
