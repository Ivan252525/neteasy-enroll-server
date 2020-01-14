package com.neteasy.manager.modules.enroll.service;

import com.neteasy.manager.modules.enroll.entity.UserEnrollInputEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户报名信息表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-14
 */
public interface UserEnrollInputService extends IService<UserEnrollInputEntity> {

    /**
     * 获取用户报名输入信息(跟随顺序)
     *
     * @param userEnrollId
     * @return
     */
    List<UserEnrollInputEntity> listWithSeq(Long userEnrollId);

}
