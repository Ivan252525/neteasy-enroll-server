package com.neteasy.server.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户收藏活动表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
@TableName("tb_user_collect_activity")
@ApiModel(value="UserCollectActivityEntity对象", description="用户收藏活动表 ")
public class UserCollectActivityEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "活动id")
    private Long activityId;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserCollectActivityEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", activityId=" + activityId +
        ", createTime=" + createTime +
        "}";
    }
}
