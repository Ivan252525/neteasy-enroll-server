package com.neteasy.manager.modules.activity.dao;

import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 活动表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-12
 */
public interface ActivityMapper extends BaseMapper<ActivityEntity> {

    List<ActivityListItemVO> listActivity(@Param("title") String title,
                                          @Param("businessId") Long businessId,
                                          @Param("jmRegionId") Long jmRegionId);

}
