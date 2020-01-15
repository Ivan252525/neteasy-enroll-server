package com.neteasy.manager.modules.index.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexActivityEntity;
import com.neteasy.manager.modules.index.entity.IndexBannerEntity;
import com.neteasy.manager.modules.index.entity.IndexBusinessEntity;
import com.neteasy.manager.modules.index.dao.IndexBusinessMapper;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBannerForm;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBusinessForm;
import com.neteasy.manager.modules.index.service.IndexBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.index.vo.IndexBusinessListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 首页商家表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
@Service
public class IndexBusinessServiceImpl extends ServiceImpl<IndexBusinessMapper, IndexBusinessEntity> implements IndexBusinessService {

    @Override
    public PageInfo<IndexBusinessListItemVO> listIndexBusiness(PageForm form) {
        return PageHelper.startPage(form.getPage(), form.getLimit())
                .doSelectPageInfo(() -> baseMapper.listIndexBusiness());
    }

    @Override
    public void addOrUpdateIndexBusiness(AddOrUpdateIndexBusinessForm form, SysUserEntity sysUserEntity) {
        IndexBusinessEntity indexBusinessEntity;
        if (form.getId() == null) {
            indexBusinessEntity = new IndexBusinessEntity();
            indexBusinessEntity.setCreateTime(new Date());
        } else {
            indexBusinessEntity = getById(form.getId());
        }

        indexBusinessEntity.setBusinessId(form.getBusinessId());
        indexBusinessEntity.setSeq(form.getSeq());
        saveOrUpdate(indexBusinessEntity);
    }
}
