package com.neteasy.manager.modules.business.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 商家表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-11
 */
@TableName("tb_business")
@ApiModel(value="BusinessEntity对象", description="商家表 ")
public class BusinessEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商家名称")
    private String businessName;

    @ApiModelProperty(value = "商家logo")
    private String logo;

    @ApiModelProperty(value = "商家介绍")
    private String businessAbout;

    @ApiModelProperty(value = "是否删除")
    private Integer deleted;

    @ApiModelProperty(value = "创建管理员id")
    private Long sysUserId;

    @ApiModelProperty(value = "创建时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBusinessAbout() {
        return businessAbout;
    }

    public void setBusinessAbout(String businessAbout) {
        this.businessAbout = businessAbout;
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
        return "BusinessEntity{" +
        "id=" + id +
        ", businessName=" + businessName +
        ", logo=" + logo +
        ", businessAbout=" + businessAbout +
        ", deleted=" + deleted +
        ", sysUserId=" + sysUserId +
        ", createTime=" + createTime +
        "}";
    }
}
