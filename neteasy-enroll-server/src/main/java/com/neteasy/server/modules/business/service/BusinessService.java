package com.neteasy.server.modules.business.service;

import com.neteasy.server.modules.business.entity.BusinessEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.server.modules.business.vo.BusinessInfoVO;
import com.neteasy.server.modules.business.vo.PreBusinessVO;
import com.neteasy.server.modules.user.entity.UserEntity;

import java.util.List;

/**
 * <p>
 * 商家表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
public interface BusinessService extends IService<BusinessEntity> {

    /**
     * 获取商家详情
     *
     * @param businessId
     * @param userEntity
     * @return
     */
    BusinessInfoVO getBusinessInfo(Long businessId, UserEntity userEntity);

    /**
     * 关注或取关商家
     *
     * @param businessId
     * @param userEntity
     */
    void likeOrRemoveLike(Long businessId, UserEntity userEntity);

    /**
     * 获取商家预览信息
     *
     * @param businessId
     * @return
     */
    PreBusinessVO getPreBusiness(Long businessId);

    /**
     * 获取用户关注商家列表
     *
     * @param userEntity
     * @return
     */
    List<PreBusinessVO> listUserLikeBusiness(UserEntity userEntity);

}
