package com.neteasy.server.modules.activity.vo;

import java.util.List;

public class ActivityInfoVO {

    private Long activityId;

    private String banner;

    private String title;

    private Integer enrollNum;

    private Integer viewNum;

    private Integer activityState;

    private String activityStateStr;

    private String activityTime;

    private String startTime;

    private String endTime;

    private String address;

    private String positionLatitude;

    private String positionLongitude;

    private String phone;

    private Integer isEnroll;

    private Integer isCollect;

    private List<String> activityDetail;

    public String getPositionLatitude() {
        return positionLatitude;
    }

    public void setPositionLatitude(String positionLatitude) {
        this.positionLatitude = positionLatitude;
    }

    public String getPositionLongitude() {
        return positionLongitude;
    }

    public void setPositionLongitude(String positionLongitude) {
        this.positionLongitude = positionLongitude;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Long getActivityId() {
        return activityId;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEnrollNum() {
        return enrollNum;
    }

    public void setEnrollNum(Integer enrollNum) {
        this.enrollNum = enrollNum;
    }

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public String getActivityStateStr() {
        return activityStateStr;
    }

    public void setActivityStateStr(String activityStateStr) {
        this.activityStateStr = activityStateStr;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsEnroll() {
        return isEnroll;
    }

    public void setIsEnroll(Integer isEnroll) {
        this.isEnroll = isEnroll;
    }

    public List<String> getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(List<String> activityDetail) {
        this.activityDetail = activityDetail;
    }
}
