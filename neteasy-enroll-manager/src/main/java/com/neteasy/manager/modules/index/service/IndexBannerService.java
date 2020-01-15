package com.neteasy.manager.modules.index.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexBannerEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBannerForm;
import com.neteasy.manager.modules.index.vo.IndexBannerListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;

import java.util.List;

/**
 * <p>
 * 首页banner表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
public interface IndexBannerService extends IService<IndexBannerEntity> {

    /**
     * 获取首页banner
     *
     * @return
     */
    PageInfo<IndexBannerListItemVO> listIndexBanner(PageForm page);

    /**
     * 新增或修改首页banner
     *
     * @param form
     */
    void addOrUpdate(AddOrUpdateIndexBannerForm form, SysUserEntity sysUserEntity);

}
