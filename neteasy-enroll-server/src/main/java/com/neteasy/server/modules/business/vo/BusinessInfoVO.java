package com.neteasy.server.modules.business.vo;

import com.neteasy.server.modules.activity.vo.PreActivityVO;

import java.util.List;

public class BusinessInfoVO {

    private Long businessId;

    private String logo;

    private String businessName;

    private String about;

    private Integer likeNum;

    private Integer isLike;

    private List<PreActivityVO> activityList;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public List<PreActivityVO> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<PreActivityVO> activityList) {
        this.activityList = activityList;
    }
}
