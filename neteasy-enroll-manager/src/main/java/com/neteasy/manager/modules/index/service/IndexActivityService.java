package com.neteasy.manager.modules.index.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexActivityEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexActivityForm;
import com.neteasy.manager.modules.index.vo.IndexActivityListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;

/**
 * <p>
 * 首页活动表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
public interface IndexActivityService extends IService<IndexActivityEntity> {

    /**
     * 首页活动列表
     *
     * @param form
     * @return
     */
    PageInfo<IndexActivityListItemVO> listIndexActivity(PageForm form);

    /**
     * 新增或修改首页活动
     *
     * @param form
     * @param sysUserEntity
     */
    void addOrUpdateIndexActivity(AddOrUpdateIndexActivityForm form, SysUserEntity sysUserEntity);

}
