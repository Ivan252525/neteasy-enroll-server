package com.neteasy.server.modules.activity.dao;

import com.neteasy.server.modules.activity.entity.ActivityCheckUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.server.modules.activity.vo.CheckActivityListItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 活动核销人表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-02-27
 */
public interface ActivityCheckUserMapper extends BaseMapper<ActivityCheckUserEntity> {

    List<CheckActivityListItemVO> listCheckActivity(@Param("userId") Long userId);

}
