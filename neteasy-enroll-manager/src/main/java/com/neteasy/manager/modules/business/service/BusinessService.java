package com.neteasy.manager.modules.business.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.business.entity.BusinessEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.business.form.AddOrUpdateBusinessForm;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;

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

    /**
     * 商家列表
     *
     * @param form
     * @return
     */
    PageInfo<BusinessListItemVO> listBusiness(ListBusinessForm form);

    /**
     * 新增商家
     *
     * @param form
     * @param sysUserEntity
     */
    void addBusiness(AddOrUpdateBusinessForm form, SysUserEntity sysUserEntity);

    /**
     * 修改商家
     *
     * @param form
     */
    void editBusiness(AddOrUpdateBusinessForm form);

    /**
     * 删除商家
     *
     * @param businessId
     */
    void removeBusiness(Long businessId);

}
