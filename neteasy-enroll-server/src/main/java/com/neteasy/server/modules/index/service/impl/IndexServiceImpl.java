package com.neteasy.server.modules.index.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.server.modules.activity.service.ActivityService;
import com.neteasy.server.modules.activity.vo.PreActivityVO;
import com.neteasy.server.modules.index.entity.IndexBannerEntity;
import com.neteasy.server.modules.index.service.IndexBannerService;
import com.neteasy.server.modules.index.service.IndexBusinessService;
import com.neteasy.server.modules.index.service.IndexService;
import com.neteasy.server.modules.index.vo.IndexBusinessVO;
import com.neteasy.server.modules.index.vo.IndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    ActivityService activityService;
    @Autowired
    IndexBannerService indexBannerService;
    @Autowired
    IndexBusinessService indexBusinessService;


    @Override
    public IndexVO getIndexData() {
        List<IndexBannerEntity> bannerEntities = indexBannerService.list(new QueryWrapper<IndexBannerEntity>().orderByAsc("seq"));
        List<PreActivityVO> preActivityVOS = activityService.listIndexActivity();
        List<IndexBusinessVO> indexBusinessVOS = indexBusinessService.listIndexBusiness();

        IndexVO vo = new IndexVO();
        vo.setBanner(bannerEntities);
        vo.setRecommendationList(preActivityVOS);
        vo.setBusinessList(indexBusinessVOS);
        return vo;
    }
}
