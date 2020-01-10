package com.neteasy.server.modules.enroll.vo;

import java.util.List;

public class UserEnrollInfoVO {

    private Long userEnrollId;

    private Long activityId;

    private String businessLogo;

    private List<UserEnrollInfoVOItem> inputItems;

    public Long getUserEnrollId() {
        return userEnrollId;
    }

    public void setUserEnrollId(Long userEnrollId) {
        this.userEnrollId = userEnrollId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    public List<UserEnrollInfoVOItem> getInputItems() {
        return inputItems;
    }

    public void setInputItems(List<UserEnrollInfoVOItem> inputItems) {
        this.inputItems = inputItems;
    }
}
