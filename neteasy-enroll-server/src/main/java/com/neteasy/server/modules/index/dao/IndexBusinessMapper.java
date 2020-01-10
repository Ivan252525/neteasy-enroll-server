package com.neteasy.server.modules.index.dao;

import com.neteasy.server.modules.index.entity.IndexBusinessEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.server.modules.index.vo.IndexBusinessVO;

import java.util.List;

/**
 * <p>
 * 首页商家表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-09
 */
public interface IndexBusinessMapper extends BaseMapper<IndexBusinessEntity> {

    List<IndexBusinessVO> listIndexBusiness();

}
