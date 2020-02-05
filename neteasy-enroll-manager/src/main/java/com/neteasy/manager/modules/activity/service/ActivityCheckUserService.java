package com.neteasy.manager.modules.activity.service;

import com.github.pagehelper.PageInfo;
import com.neteasy.manager.modules.activity.entity.ActivityCheckUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.manager.modules.activity.form.ListCheckUserForm;
import com.neteasy.manager.modules.activity.vo.CheckUserListItemVO;

/**
 * <p>
 * 活动核销人表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-02-04
 */
public interface ActivityCheckUserService extends IService<ActivityCheckUserEntity> {

    PageInfo<CheckUserListItemVO> listCheckUser(ListCheckUserForm form);

}
