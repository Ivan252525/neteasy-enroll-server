package com.neteasy.manager.modules.business.form;

import com.neteasy.common.web.page.PageForm;

public class ListBusinessForm {

    private String businessName;

    private PageForm page;

    public PageForm getPage() {
        return page;
    }

    public void setPage(PageForm page) {
        this.page = page;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
