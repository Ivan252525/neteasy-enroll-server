package com.neteasy.manager.modules.index.dao;

import com.neteasy.manager.modules.index.entity.IndexActivityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.manager.modules.index.vo.IndexActivityListItemVO;

import java.util.List;

/**
 * <p>
 * 首页活动表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
public interface IndexActivityMapper extends BaseMapper<IndexActivityEntity> {

    List<IndexActivityListItemVO> listIndexActivity();

}
