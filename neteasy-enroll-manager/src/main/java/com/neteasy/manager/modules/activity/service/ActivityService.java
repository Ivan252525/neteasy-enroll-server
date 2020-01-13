package com.neteasy.manager.modules.activity.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;

import java.util.List;

/**
 * <p>
 * 活动表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-12
 */
public interface ActivityService extends IService<ActivityEntity> {

    /**
     * 获取活动列表
     *
     * @param form
     * @return
     */
    PageInfo<ActivityListItemVO> listActivity(SearchActivityListForm form);

}
