package com.neteasy.manager.modules.activity.form;

import com.neteasy.common.web.page.PageForm;

import javax.validation.constraints.NotNull;

public class ListCheckUserForm {

    @NotNull
    private Long activityId;

    @NotNull
    private PageForm page;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public PageForm getPage() {
        return page;
    }

    public void setPage(PageForm page) {
        this.page = page;
    }
}
