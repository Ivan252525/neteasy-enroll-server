package com.neteasy.manager.modules.activity.form;

import com.neteasy.common.web.page.PageForm;

public class SearchActivityListForm {

    private String title;

    private Long businessId;

    private Long jmRegionId;

    private PageForm page;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getJmRegionId() {
        return jmRegionId;
    }

    public void setJmRegionId(Long jmRegionId) {
        this.jmRegionId = jmRegionId;
    }

    public PageForm getPage() {
        return page;
    }

    public void setPage(PageForm page) {
        this.page = page;
    }
}
