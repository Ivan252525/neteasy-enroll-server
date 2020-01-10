package com.neteasy.server.modules.enroll.form;

import javax.validation.constraints.NotNull;
import java.util.List;

public class EnrollForm {

    @NotNull
    private Long activityId;

    @NotNull
    private List<EnrollFormItem> formItems;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public List<EnrollFormItem> getFormItems() {
        return formItems;
    }

    public void setFormItems(List<EnrollFormItem> formItems) {
        this.formItems = formItems;
    }
}
