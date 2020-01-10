package com.neteasy.server.modules.activity.vo;

import java.util.List;

public class ActivityFormItemVO {

    private Long formItemId;

    private Integer type;

    private String label;

    private Integer must;

    private List<String> options;

    public Long getFormItemId() {
        return formItemId;
    }

    public void setFormItemId(Long formItemId) {
        this.formItemId = formItemId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getMust() {
        return must;
    }

    public void setMust(Integer must) {
        this.must = must;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
