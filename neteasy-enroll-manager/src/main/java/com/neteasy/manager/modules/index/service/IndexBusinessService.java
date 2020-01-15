package com.neteasy.manager.modules.index.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexBusinessEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexActivityForm;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBannerForm;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBusinessForm;
import com.neteasy.manager.modules.index.vo.IndexActivityListItemVO;
import com.neteasy.manager.modules.index.vo.IndexBusinessListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;

/**
 * <p>
 * 首页商家表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
public interface IndexBusinessService extends IService<IndexBusinessEntity> {

    /**
     * 首页商家列表
     *
     * @param form
     * @return
     */
    PageInfo<IndexBusinessListItemVO> listIndexBusiness(PageForm form);

    /**
     * 新增或修改首页商家
     *
     * @param form
     * @param sysUserEntity
     */
    void addOrUpdateIndexBusiness(AddOrUpdateIndexBusinessForm form, SysUserEntity sysUserEntity);

}
