package com.neteasy.manager.modules.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.activity.entity.ActivityCheckUserEntity;
import com.neteasy.manager.modules.activity.dao.ActivityCheckUserMapper;
import com.neteasy.manager.modules.activity.form.AddCheckUserForm;
import com.neteasy.manager.modules.activity.form.ListCheckUserForm;
import com.neteasy.manager.modules.activity.service.ActivityCheckUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.manager.modules.activity.vo.CheckUserListItemVO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 活动核销人表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-02-04
 */
@Service
public class ActivityCheckUserServiceImpl extends ServiceImpl<ActivityCheckUserMapper, ActivityCheckUserEntity> implements ActivityCheckUserService {

    @Override
    public PageInfo<CheckUserListItemVO> listCheckUser(ListCheckUserForm form) {
        return PageHelper.startPage(form.getPage().getPage(), form.getPage().getLimit())
                .doSelectPageInfo(() -> baseMapper.listCheckUserByActivityId(form.getActivityId()));
    }

    @Override
    public void addCheckUser(AddCheckUserForm form) {
        ActivityCheckUserEntity entity = new ActivityCheckUserEntity();
        entity.setActivityId(form.getActivityId());
        entity.setUserId(form.getUserId());
        entity.setCreateTime(new Date());
        save(entity);
    }
}
