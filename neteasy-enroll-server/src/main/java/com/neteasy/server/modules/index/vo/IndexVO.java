package com.neteasy.server.modules.index.vo;

import com.neteasy.server.modules.activity.vo.PreActivityVO;
import com.neteasy.server.modules.index.entity.IndexBannerEntity;

import java.util.List;

public class IndexVO {

    private List<IndexBannerEntity> banner;

    private List<PreActivityVO> recommendationList;

    private List<IndexBusinessVO> businessList;

    public List<IndexBannerEntity> getBanner() {
        return banner;
    }

    public void setBanner(List<IndexBannerEntity> banner) {
        this.banner = banner;
    }

    public List<PreActivityVO> getRecommendationList() {
        return recommendationList;
    }

    public void setRecommendationList(List<PreActivityVO> recommendationList) {
        this.recommendationList = recommendationList;
    }

    public List<IndexBusinessVO> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<IndexBusinessVO> businessList) {
        this.businessList = businessList;
    }
}
