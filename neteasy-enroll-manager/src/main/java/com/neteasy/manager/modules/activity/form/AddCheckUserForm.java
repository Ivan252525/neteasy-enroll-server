package com.neteasy.manager.modules.activity.form;

import javax.validation.constraints.NotNull;

public class AddCheckUserForm {

    @NotNull
    private Long userId;

    @NotNull
    private Long activityId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
