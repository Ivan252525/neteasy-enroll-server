package com.neteasy.server.modules.activity.vo;

public class CheckActivityListItemVO {

    private Long activityId;

    private String mainImage;

    private String title;

    private String date;

    private String position;

    private Integer enrollCount;

    private Integer checkCount;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getEnrollCount() {
        return enrollCount;
    }

    public void setEnrollCount(Integer enrollCount) {
        this.enrollCount = enrollCount;
    }

    public Integer getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }
}
