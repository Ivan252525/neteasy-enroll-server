package com.neteasy.manager.modules.activity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 活动表单条目表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-14
 */
@TableName("tb_activity_form_item")
@ApiModel(value="ActivityFormItemEntity对象", description="活动表单条目表 ")
public class ActivityFormItemEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "活动id")
    private Long activityId;

    @ApiModelProperty(value = "标签名")
    private String label;

    @ApiModelProperty(value = "是否必填 0-选填/1-必填")
    private Integer must;

    @ApiModelProperty(value = "表单类型")
    private Integer type;

    @ApiModelProperty(value = "排序 从小到大排")
    private Integer seq;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ActivityFormItemEntity{" +
        "id=" + id +
        ", activityId=" + activityId +
        ", label=" + label +
        ", must=" + must +
        ", type=" + type +
        ", seq=" + seq +
        ", createTime=" + createTime +
        "}";
    }
}
