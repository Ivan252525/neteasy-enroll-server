package com.neteasy.server.modules.enroll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户报名表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
@TableName("tb_user_enroll")
@ApiModel(value="UserEnrollEntity对象", description="用户报名表 ")
public class UserEnrollEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "活动id")
    private Long activityId;

    @ApiModelProperty(value = "核销码")
    private String checkCode;

    @ApiModelProperty(value = "核销状态 0-未核销/1-已核销")
    private Integer checkState;

    @ApiModelProperty(value = "核销类型 1-商家核销/2-管理员手动核销")
    private Integer checkType;

    @ApiModelProperty(value = "核销时间")
    private Date checkTime;

    @ApiModelProperty(value = "核销用户id")
    private Long checkUserId;

    @ApiModelProperty(value = "核销管理员id")
    private Long checkSysUserId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Long getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Long checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Long getCheckSysUserId() {
        return checkSysUserId;
    }

    public void setCheckSysUserId(Long checkSysUserId) {
        this.checkSysUserId = checkSysUserId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserEnrollEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", createTime=" + createTime +
        "}";
    }
}
