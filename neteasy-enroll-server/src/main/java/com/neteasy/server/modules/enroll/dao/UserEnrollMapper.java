package com.neteasy.server.modules.enroll.dao;

import com.neteasy.server.modules.enroll.entity.UserEnrollEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neteasy.server.modules.enroll.vo.PreUserEnroll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户报名表  Mapper 接口
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
public interface UserEnrollMapper extends BaseMapper<UserEnrollEntity> {

    List<PreUserEnroll> listPreUserEnroll(@Param("userId") Long userId);

}
