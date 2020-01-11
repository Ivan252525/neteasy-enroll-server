package com.neteasy.manager.modules.business.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.business.entity.BusinessEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;

import java.util.List;

/**
 * <p>
 * 商家表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-11
 */
public interface BusinessService extends IService<BusinessEntity> {

    PageInfo<BusinessListItemVO> listBusiness(ListBusinessForm form);

}
