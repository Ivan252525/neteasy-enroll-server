package com.neteasy.manager.modules.activity.dao;

import com.neteasy.manager.modules.activity.entity.ActivityCheckUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.manager.modules.activity.vo.CheckUserListItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 活动核销人表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-02-04
 */
public interface ActivityCheckUserMapper extends BaseMapper<ActivityCheckUserEntity> {

    List<CheckUserListItemVO> listCheckUserByActivityId(@Param("activityId") Long activityId);

}
