package com.neteasy.server.modules.activity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 活动表单条目选项表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
@TableName("tb_activity_form_item_option")
@ApiModel(value="ActivityFormItemOptionEntity对象", description="活动表单条目选项表 ")
public class ActivityFormItemOptionEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "表单条目id")
    private Long formItemId;

    @ApiModelProperty(value = "选项")
    private String optionValue;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFormItemId() {
        return formItemId;
    }

    public void setFormItemId(Long formItemId) {
        this.formItemId = formItemId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ActivityFormItemOptionEntity{" +
        "id=" + id +
        ", formItemId=" + formItemId +
        ", optionValue=" + optionValue +
        ", createTime=" + createTime +
        "}";
    }
}
