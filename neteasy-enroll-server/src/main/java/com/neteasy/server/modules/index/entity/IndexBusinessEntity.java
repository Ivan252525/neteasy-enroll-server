package com.neteasy.server.modules.index.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 首页商家表 
 * </p>
 *
 * @author Ivan
 * @since 2020-01-09
 */
@TableName("tb_index_business")
@ApiModel(value="IndexBusinessEntity对象", description="首页商家表 ")
public class IndexBusinessEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商家id")
    private Long businessId;

    @ApiModelProperty(value = "排序 从小到大")
    private Integer seq;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


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
        return "IndexBusinessEntity{" +
        "id=" + id +
        ", businessId=" + businessId +
        ", seq=" + seq +
        ", createTime=" + createTime +
        "}";
    }
}
