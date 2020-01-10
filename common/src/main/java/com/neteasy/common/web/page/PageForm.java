package com.neteasy.common.web.page;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: Ivan
 * @date: 2019/2/17 09:45
 */
public class PageForm {

    @ApiModelProperty(value = "页码 从1开始")
    private Integer page;

    @ApiModelProperty(value = "每页数据大小")
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
