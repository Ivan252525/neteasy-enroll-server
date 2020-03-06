package com.neteasy.server.modules.activity.service;

import com.neteasy.server.modules.activity.entity.ActivityCheckUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.server.modules.activity.vo.CheckActivityListItemVO;
import com.neteasy.server.modules.user.entity.UserEntity;

import java.util.List;

/**
 * <p>
 * 活动核销人表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-02-27
 */
public interface ActivityCheckUserService extends IService<ActivityCheckUserEntity> {

    /**
     * 获取用户核销活动列表
     *
     * @param userEntity
     * @return
     */
    List<CheckActivityListItemVO> listCheckActivity(UserEntity userEntity);

}
