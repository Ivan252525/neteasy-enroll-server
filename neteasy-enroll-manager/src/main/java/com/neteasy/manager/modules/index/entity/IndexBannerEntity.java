package com.neteasy.manager.modules.index.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 首页banner表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-15
 */
@TableName("tb_index_banner")
@ApiModel(value="IndexBannerEntity对象", description="首页banner表 ")
public class IndexBannerEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "图片url")
    private String imageUrl;

    @ApiModelProperty(value = "排序 从小到大")
    private Integer seq;

    @ApiModelProperty(value = "跳转类型 1-活动/2-网页")
    private Integer type;

    @ApiModelProperty(value = "活动id")
    private Long activityId;

    @ApiModelProperty(value = "网页链接")
    private String webUrl;

    @ApiModelProperty(value = "创建管理员id")
    private Long sysUserId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "IndexBannerEntity{" +
        "id=" + id +
        ", imageUrl=" + imageUrl +
        ", seq=" + seq +
        ", type=" + type +
        ", activityId=" + activityId +
        ", webUrl=" + webUrl +
        ", sysUserId=" + sysUserId +
        ", createTime=" + createTime +
        "}";
    }
}
