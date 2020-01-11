package com.neteasy.manager.modules.business.dao;

import com.neteasy.manager.modules.business.entity.BusinessEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-11
 */
public interface BusinessMapper extends BaseMapper<BusinessEntity> {

    List<BusinessListItemVO> listBusiness(@Param("businessName") String businessName);

}
