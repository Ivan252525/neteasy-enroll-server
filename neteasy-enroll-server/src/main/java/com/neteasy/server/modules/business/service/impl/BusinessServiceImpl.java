package com.neteasy.server.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neteasy.server.modules.activity.entity.ActivityEntity;
import com.neteasy.server.modules.activity.service.ActivityService;
import com.neteasy.server.modules.activity.vo.PreActivityVO;
import com.neteasy.server.modules.business.entity.BusinessEntity;
import com.neteasy.server.modules.business.dao.BusinessMapper;
import com.neteasy.server.modules.business.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.server.modules.business.vo.BusinessInfoVO;
import com.neteasy.server.modules.business.vo.PreBusinessVO;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.modules.user.entity.UserLikeBusinessEntity;
import com.neteasy.server.modules.user.service.UserLikeBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商家表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-08
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, BusinessEntity> implements BusinessService {

    @Autowired
    UserLikeBusinessService userLikeBusinessService;
    @Autowired
    ActivityService activityService;

    @Override
    public BusinessInfoVO getBusinessInfo(Long businessId, UserEntity userEntity) {

        // 获取商家实体
        BusinessEntity businessEntity = getById(businessId);

        // 获取商家活动
        List<PreActivityVO> preActivityVOS = activityService.listBusinessActivity(businessId);

        // 获取关注人数
        int likeNum = userLikeBusinessService.count(new QueryWrapper<UserLikeBusinessEntity>().eq("business_id", businessId));

        // 如果用户已登陆，检查用户是否已关注
        int isLike = 0;
        if (userEntity != null) {
            UserLikeBusinessEntity userLikeBusinessEntity = userLikeBusinessService
                    .getOne(new QueryWrapper<UserLikeBusinessEntity>()
                    .eq("business_id", businessId)
                    .eq("user_id", userEntity.getId()));
            if (userLikeBusinessEntity != null) {
                isLike = 1;
            }
        }

        BusinessInfoVO vo = new BusinessInfoVO();
        vo.setBusinessId(businessId);
        vo.setBusinessName(businessEntity.getBusinessName());
        vo.setLogo(businessEntity.getLogo());
        vo.setAbout(businessEntity.getBusinessAbout());
        vo.setLikeNum(likeNum);
        vo.setIsLike(isLike);
        vo.setActivityList(preActivityVOS);

        return vo;
    }

    @Override
    public void likeOrRemoveLike(Long businessId, UserEntity userEntity) {
        UserLikeBusinessEntity userLikeBusinessEntity = userLikeBusinessService
                .getOne(new QueryWrapper<UserLikeBusinessEntity>()
                        .eq("business_id", businessId)
                        .eq("user_id", userEntity.getId()));
        if (userLikeBusinessEntity == null) {
            // 添加关注
            userLikeBusinessEntity = new UserLikeBusinessEntity();
            userLikeBusinessEntity.setBusinessId(businessId);
            userLikeBusinessEntity.setUserId(userEntity.getId());
            userLikeBusinessEntity.setCreateTime(new Date());
            userLikeBusinessService.save(userLikeBusinessEntity);
        } else {
            // 取消关注
            userLikeBusinessService.removeById(userLikeBusinessEntity.getId());
        }
    }

    @Override
    public PreBusinessVO getPreBusiness(Long businessId) {
        // 获取商家实体
        BusinessEntity businessEntity = getById(businessId);

        // 获取商家活动数
        int activityNum = activityService.count(new QueryWrapper<ActivityEntity>()
                .eq("business_id", businessEntity.getId())
                .eq("state", 1)
                .eq("deleted", 0));

        PreBusinessVO vo = new PreBusinessVO();
        vo.setId(businessId);
        vo.setLogo(businessEntity.getLogo());
        vo.setBusinessName(businessEntity.getBusinessName());
        vo.setActivityNum(activityNum);
        return vo;
    }

    @Override
    public List<PreBusinessVO> listUserLikeBusiness(UserEntity userEntity) {
        return baseMapper.listUserLikeBusiness(userEntity.getId());
    }
}
