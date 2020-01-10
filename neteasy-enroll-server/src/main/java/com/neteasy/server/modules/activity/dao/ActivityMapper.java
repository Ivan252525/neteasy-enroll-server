package com.neteasy.server.modules.activity.dao;

import com.neteasy.server.modules.activity.entity.ActivityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.server.modules.activity.vo.PreActivityVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 活动表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
public interface ActivityMapper extends BaseMapper<ActivityEntity> {

    List<PreActivityVO> listBusinessActivity(@Param("businessId") Long businessId);

    List<PreActivityVO> listActivity(@Param("jmRegionId") Long jmRegionId,
                                     @Param("enrollState") Integer enrollState);

    List<PreActivityVO> listIndexActivity();

    List<PreActivityVO> listUserCollect(@Param("userId") Long userId);

}
