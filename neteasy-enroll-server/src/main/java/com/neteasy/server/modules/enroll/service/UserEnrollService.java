package com.neteasy.server.modules.enroll.service;

import com.neteasy.server.modules.enroll.entity.UserEnrollEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.server.modules.enroll.form.CancelEnrollForm;
import com.neteasy.server.modules.enroll.form.EnrollForm;
import com.neteasy.server.modules.enroll.vo.CheckCodeInfoVO;
import com.neteasy.server.modules.enroll.vo.PreUserEnroll;
import com.neteasy.server.modules.enroll.vo.UserEnrollInfoVO;
import com.neteasy.server.modules.user.entity.UserEntity;

import java.util.List;

/**
 * <p>
 * 用户报名表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
public interface UserEnrollService extends IService<UserEnrollEntity> {

    /**
     * 用户报名
     *
     * @param form
     * @param userEntity
     */
    void userEnroll(EnrollForm form, UserEntity userEntity);

    /**
     * 用户报名列表
     *
     * @param userId
     * @return
     */
    List<PreUserEnroll> listPreUserEnroll(Long userId);

    /**
     * 获取用户报名详情
     *
     * @param userEnrollId
     * @return
     */
    UserEnrollInfoVO getUserEnrollInfo(Long userEnrollId);

    /**
     * 取消报名
     *
     * @param form
     * @param userEntity
     */
    void cancelEnroll(CancelEnrollForm form, UserEntity userEntity);

    /**
     * 获取报名核销码详情
     *
     * @param enrollId
     */
    CheckCodeInfoVO getCheckCodeInfo(Long enrollId);

    /**
     * 核销报名
     *
     * @param checkCode
     * @param userEntity
     * @return
     */
    UserEnrollInfoVO checkUserEnroll(String checkCode, UserEntity userEntity);

}
