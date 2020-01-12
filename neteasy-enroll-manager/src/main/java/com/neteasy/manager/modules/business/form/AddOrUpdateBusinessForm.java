package com.neteasy.manager.modules.business.form;

import javax.validation.constraints.NotNull;

public class AddOrUpdateBusinessForm {

    private Long businessId;

    @NotNull
    private String businessName;

    @NotNull
    private String businessLogo;

    @NotNull
    private String businessAbout;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    public String getBusinessAbout() {
        return businessAbout;
    }

    public void setBusinessAbout(String businessAbout) {
        this.businessAbout = businessAbout;
    }
}
