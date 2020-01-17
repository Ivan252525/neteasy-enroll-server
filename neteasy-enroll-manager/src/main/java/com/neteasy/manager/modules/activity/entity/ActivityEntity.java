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
 * 活动表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-12
 */
@TableName("tb_activity")
@ApiModel(value="ActivityEntity对象", description="活动表 ")
public class ActivityEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商家id")
    private Long businessId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "橱窗图")
    private String mainImage;

    @ApiModelProperty(value = "活动banner")
    private String banner;

    @ApiModelProperty(value = "活动开始时间")
    private Date activityStartTime;

    @ApiModelProperty(value = "活动结束时间")
    private Date activityEndTime;

    @ApiModelProperty(value = "报名开始时间")
    private Date enrollStartTime;

    @ApiModelProperty(value = "报名结束时间")
    private Date enrollEndTime;

    @ApiModelProperty(value = "江门地区id")
    private Long jmRegionId;

    @ApiModelProperty(value = "活动地点")
    private String address;

    @ApiModelProperty(value = "纬度")
    private String positionLatitude;

    @ApiModelProperty(value = "经度")
    private String positionLongitude;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "状态 0-下架/1-上架")
    private Integer state;

    @ApiModelProperty(value = "是否删除 0-未删除/1-删除")
    private Integer deleted;

    @ApiModelProperty(value = "创建管理员id")
    private Long sysUserId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public String getPositionLatitude() {
        return positionLatitude;
    }

    public void setPositionLatitude(String positionLatitude) {
        this.positionLatitude = positionLatitude;
    }

    public String getPositionLongitude() {
        return positionLongitude;
    }

    public void setPositionLongitude(String positionLongitude) {
        this.positionLongitude = positionLongitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Date getEnrollStartTime() {
        return enrollStartTime;
    }

    public void setEnrollStartTime(Date enrollStartTime) {
        this.enrollStartTime = enrollStartTime;
    }

    public Date getEnrollEndTime() {
        return enrollEndTime;
    }

    public void setEnrollEndTime(Date enrollEndTime) {
        this.enrollEndTime = enrollEndTime;
    }

    public Long getJmRegionId() {
        return jmRegionId;
    }

    public void setJmRegionId(Long jmRegionId) {
        this.jmRegionId = jmRegionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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
        return "ActivityEntity{" +
        "id=" + id +
        ", businessId=" + businessId +
        ", title=" + title +
        ", mainImage=" + mainImage +
        ", banner=" + banner +
        ", activityStartTime=" + activityStartTime +
        ", activityEndTime=" + activityEndTime +
        ", enrollStartTime=" + enrollStartTime +
        ", enrollEndTime=" + enrollEndTime +
        ", jmRegionId=" + jmRegionId +
        ", address=" + address +
        ", phone=" + phone +
        ", state=" + state +
        ", deleted=" + deleted +
        ", sysUserId=" + sysUserId +
        ", createTime=" + createTime +
        "}";
    }
}
