package com.neteasy.manager.modules.enroll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户报名信息表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-14
 */
@TableName("tb_user_enroll_input")
@ApiModel(value="UserEnrollInputEntity对象", description="用户报名信息表 ")
public class UserEnrollInputEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "活动id")
    private Long activityId;

    @ApiModelProperty(value = "报名id")
    private Long enrollId;

    @ApiModelProperty(value = "表单条目id")
    private Long formItemId;

    @ApiModelProperty(value = "输入信息")
    private String inputValue;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }

    public Long getFormItemId() {
        return formItemId;
    }

    public void setFormItemId(Long formItemId) {
        this.formItemId = formItemId;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserEnrollInputEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", activityId=" + activityId +
        ", enrollId=" + enrollId +
        ", formItemId=" + formItemId +
        ", inputValue=" + inputValue +
        ", createTime=" + createTime +
        "}";
    }
}
