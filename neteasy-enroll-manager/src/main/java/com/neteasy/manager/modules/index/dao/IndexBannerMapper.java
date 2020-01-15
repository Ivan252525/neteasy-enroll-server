package com.neteasy.manager.modules.index.dao;

import com.neteasy.manager.modules.index.entity.IndexBannerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.manager.modules.index.vo.IndexBannerListItemVO;

import java.util.List;

/**
 * <p>
 * 首页banner表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
public interface IndexBannerMapper extends BaseMapper<IndexBannerEntity> {

    List<IndexBannerListItemVO> listIndexBanner();

    int updateIndexBanner(IndexBannerEntity entity);

}
