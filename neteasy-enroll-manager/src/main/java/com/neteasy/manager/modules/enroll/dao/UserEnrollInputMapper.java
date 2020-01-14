package com.neteasy.manager.modules.enroll.dao;

import com.neteasy.manager.modules.enroll.entity.UserEnrollInputEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户报名信息表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-14
 */
public interface UserEnrollInputMapper extends BaseMapper<UserEnrollInputEntity> {

    List<UserEnrollInputEntity> listWithOrder(@Param("userEnrollId") Long userEnrollId);

}
