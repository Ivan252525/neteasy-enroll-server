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
 * 活动详情图表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-14
 */
@TableName("tb_activity_detail_image")
@ApiModel(value="ActivityDetailImageEntity对象", description="活动详情图表 ")
public class ActivityDetailImageEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "活动id")
    private Long activityId;

    @ApiModelProperty(value = "图片url")
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ActivityDetailImageEntity{" +
        "id=" + id +
        ", activityId=" + activityId +
        ", imageUrl=" + imageUrl +
        ", createTime=" + createTime +
        "}";
    }
}
