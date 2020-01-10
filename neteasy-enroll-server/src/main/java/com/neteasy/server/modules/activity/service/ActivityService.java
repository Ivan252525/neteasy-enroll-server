package com.neteasy.server.modules.activity.service;

import com.neteasy.server.modules.activity.entity.ActivityEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.server.modules.activity.vo.ActivityFormItemVO;
import com.neteasy.server.modules.activity.vo.ActivityInfoViewVO;
import com.neteasy.server.modules.activity.vo.PreActivityVO;
import com.neteasy.server.modules.user.entity.UserEntity;

import java.util.List;

/**
 * <p>
 * 活动表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
public interface ActivityService extends IService<ActivityEntity> {

    /**
     * 获取商家活动列表
     *
     * @param businessId
     * @return
     */
    List<PreActivityVO> listBusinessActivity(Long businessId);

    /**
     * 活动列表
     *
     * @param enrollState
     * @param jmRegionId
     * @return
     */
    List<PreActivityVO> listActivity(Integer enrollState, Long jmRegionId);

    /**
     * 获取活动详情
     *
     * @param activityId
     * @param userEntity
     * @return
     */
    ActivityInfoViewVO getActivityInfo(Long activityId, UserEntity userEntity);

    /**
     * 收藏或取消收藏活动
     *
     * @param activityId
     * @param userEntity
     */
    void collectOrRemove(Long activityId, UserEntity userEntity);

    /**
     * 获取活动报名表单
     *
     * @param activityId
     * @return
     */
    List<ActivityFormItemVO> listActivityFormItem(Long activityId);

    /**
     * 获取首页活动列表
     *
     * @return
     */
    List<PreActivityVO> listIndexActivity();

    /**
     * 获取用户收藏列表
     *
     * @param userEntity
     * @return
     */
    List<PreActivityVO> listUserCollect(UserEntity userEntity);

}
