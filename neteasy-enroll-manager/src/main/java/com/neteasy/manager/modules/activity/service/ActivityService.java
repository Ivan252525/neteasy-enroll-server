package com.neteasy.manager.modules.activity.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.activity.form.AddActivityForm;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.vo.ActivityInfoVO;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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

    /**
     * 新增活动
     *
     * @param form
     * @param sysUserEntity
     */
    void addActivity(AddActivityForm form, SysUserEntity sysUserEntity);

    /**
     * 获取活动详情
     *
     * @param activityId
     * @return
     */
    ActivityInfoVO getActivityInfo(Long activityId);

    /**
     * 获取报名名单Excel
     *
     * @param activityId
     * @return
     */
    HSSFWorkbook getEnrollExcel(Long activityId);

}
