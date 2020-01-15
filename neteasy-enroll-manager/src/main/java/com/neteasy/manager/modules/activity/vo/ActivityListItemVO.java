package com.neteasy.manager.modules.activity.vo;

import java.util.Date;

public class ActivityListItemVO {

    private Long id;

    private String mainImage;

    private String title;

    private String businessName;

    private String jmRegionName;

    private Integer enrollNum;

    private Date enrollStartTime;

    private Date enrollEndTime;

    private String createTime;

    private Integer state;

    private Integer enrollState;

    public Date getEnrollStartTime() {
        return enrollStartTime;
    }

    public void setEnrollStartTime(Date enrollStartTime) {
        this.enrollStartTime = enrollStartTime;
    }

    public Date getEnrollEndTime() {
        return enrollEndTime;
    }

    public void setEnrollEndTime(Date enrollEndTime) {
        this.enrollEndTime = enrollEndTime;
    }

    public Integer getEnrollState() {
        return enrollState;
    }

    public void setEnrollState(Integer enrollState) {
        this.enrollState = enrollState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getJmRegionName() {
        return jmRegionName;
    }

    public void setJmRegionName(String jmRegionName) {
        this.jmRegionName = jmRegionName;
    }

    public Integer getEnrollNum() {
        return enrollNum;
    }

    public void setEnrollNum(Integer enrollNum) {
        this.enrollNum = enrollNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
