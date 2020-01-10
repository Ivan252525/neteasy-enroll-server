package com.neteasy.server.modules.business.dao;

import com.neteasy.server.modules.business.entity.BusinessEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.server.modules.business.vo.BusinessInfoVO;
import com.neteasy.server.modules.business.vo.PreBusinessVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
public interface BusinessMapper extends BaseMapper<BusinessEntity> {

    List<PreBusinessVO> listUserLikeBusiness(@Param("userId") Long userId);

}
