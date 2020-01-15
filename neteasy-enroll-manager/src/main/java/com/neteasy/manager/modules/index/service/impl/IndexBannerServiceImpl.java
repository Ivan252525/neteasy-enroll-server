package com.neteasy.manager.modules.index.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexBannerEntity;
import com.neteasy.manager.modules.index.dao.IndexBannerMapper;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBannerForm;
import com.neteasy.manager.modules.index.service.IndexBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.index.vo.IndexBannerListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 首页banner表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
@Service
public class IndexBannerServiceImpl extends ServiceImpl<IndexBannerMapper, IndexBannerEntity> implements IndexBannerService {

    @Override
    public PageInfo<IndexBannerListItemVO> listIndexBanner(PageForm page) {
        return PageHelper.startPage(page.getPage(), page.getLimit())
                .doSelectPageInfo(() -> {baseMapper.listIndexBanner();});
    }

    @Override
    public void addOrUpdate(AddOrUpdateIndexBannerForm form, SysUserEntity sysUserEntity) {
        IndexBannerEntity bannerEntity;
        if (form.getId() == null) {
            // 新增
            bannerEntity = new IndexBannerEntity();
            bannerEntity.setSysUserId(sysUserEntity.getId());
            bannerEntity.setCreateTime(new Date());
        } else {
            // 修改
            bannerEntity = getById(form.getId());
        }

        bannerEntity.setImageUrl(form.getImageUrl());
        bannerEntity.setSeq(form.getSeq());
        bannerEntity.setType(form.getType());
        bannerEntity.setActivityId(form.getType() == 1 ? form.getActivityId() : null);
        bannerEntity.setWebUrl(form.getType() == 2 ? form.getWebUrl() : null);

        if (bannerEntity.getId() == null) {
            save(bannerEntity);
        } else {
            baseMapper.updateIndexBanner(bannerEntity);
        }
    }
}
