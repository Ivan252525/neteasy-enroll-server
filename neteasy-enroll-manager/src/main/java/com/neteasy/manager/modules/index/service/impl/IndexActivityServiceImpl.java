package com.neteasy.manager.modules.index.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexActivityEntity;
import com.neteasy.manager.modules.index.dao.IndexActivityMapper;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexActivityForm;
import com.neteasy.manager.modules.index.service.IndexActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.index.vo.IndexActivityListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 首页活动表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
@Service
public class IndexActivityServiceImpl extends ServiceImpl<IndexActivityMapper, IndexActivityEntity> implements IndexActivityService {

    @Override
    public PageInfo<IndexActivityListItemVO> listIndexActivity(PageForm form) {
        return PageHelper.startPage(form.getPage(), form.getLimit())
                .doSelectPageInfo(() -> baseMapper.listIndexActivity());
    }

    @Override
    public void addOrUpdateIndexActivity(AddOrUpdateIndexActivityForm form, SysUserEntity sysUserEntity) {
        IndexActivityEntity indexActivityEntity;
        if (form.getId() == null) {
            indexActivityEntity = new IndexActivityEntity();
            indexActivityEntity.setCreateTime(new Date());
        } else {
            indexActivityEntity = getById(form.getId());
        }

        indexActivityEntity.setActivityId(form.getActivityId());
        indexActivityEntity.setSeq(form.getSeq());
        saveOrUpdate(indexActivityEntity);
    }
}
