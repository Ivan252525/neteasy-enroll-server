package com.neteasy.manager.modules.business.vo;

public class BusinessListItemVO {

    private Long id;

    private String businessLogo;

    private String businessName;

    private String createManagerName;

    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCreateManagerName() {
        return createManagerName;
    }

    public void setCreateManagerName(String createManagerName) {
        this.createManagerName = createManagerName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
