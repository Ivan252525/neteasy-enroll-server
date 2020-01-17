package com.neteasy.manager.modules.activity.form;

import java.util.List;

public class AddActivityForm {

    private Long businessId;

    private String title;

    private String mainImage;

    private String banner;

    private String activityStartTime;

    private String activityEndTime;

    private String enrollStartTime;

    private String enrollEndTime;

    private Long jmRegionId;

    private String address;

    private String positionLatitude;

    private String positionLongitude;

    private String phone;

    private List<String> detailImage;

    private List<FormItemForm> formItems;

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

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getEnrollStartTime() {
        return enrollStartTime;
    }

    public void setEnrollStartTime(String enrollStartTime) {
        this.enrollStartTime = enrollStartTime;
    }

    public String getEnrollEndTime() {
        return enrollEndTime;
    }

    public void setEnrollEndTime(String enrollEndTime) {
        this.enrollEndTime = enrollEndTime;
    }

    public Long getJmRegionId() {
        return jmRegionId;
    }

    public void setJmRegionId(Long jmRegionId) {
        this.jmRegionId = jmRegionId;
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

    public List<String> getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(List<String> detailImage) {
        this.detailImage = detailImage;
    }

    public List<FormItemForm> getFormItems() {
        return formItems;
    }

    public void setFormItems(List<FormItemForm> formItems) {
        this.formItems = formItems;
    }
}
