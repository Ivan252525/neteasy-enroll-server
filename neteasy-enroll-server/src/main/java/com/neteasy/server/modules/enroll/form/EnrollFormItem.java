package com.neteasy.server.modules.enroll.form;

import javax.validation.constraints.NotNull;

public class EnrollFormItem {

    @NotNull
    private Long formItemId;

    @NotNull
    private String value;

    public Long getFormItemId() {
        return formItemId;
    }

    public void setFormItemId(Long formItemId) {
        this.formItemId = formItemId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
