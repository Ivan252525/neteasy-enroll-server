package com.neteasy.manager.modules.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.neteasy.manager.modules.activity.dao.ActivityMapper;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 活动表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-12
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, ActivityEntity> implements ActivityService {

    @Override
    public PageInfo<ActivityListItemVO> listActivity(SearchActivityListForm form) {
        return PageHelper.startPage(form.getPage().getPage(),
                form.getPage().getLimit()).doSelectPageInfo(() -> {
            baseMapper.listActivity(form.getTitle(), form.getBusinessId(), form.getJmRegionId());
        });
    }
}
