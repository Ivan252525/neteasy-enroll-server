package com.neteasy.manager.modules.index.dao;

import com.neteasy.manager.modules.index.entity.IndexBusinessEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.manager.modules.index.vo.IndexBusinessListItemVO;

import java.util.List;

/**
 * <p>
 * 首页商家表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
public interface IndexBusinessMapper extends BaseMapper<IndexBusinessEntity> {

    List<IndexBusinessListItemVO> listIndexBusiness();

}
