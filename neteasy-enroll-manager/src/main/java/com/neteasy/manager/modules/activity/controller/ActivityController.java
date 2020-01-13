package com.neteasy.manager.modules.activity.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.service.ActivityService;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import com.neteasy.manager.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/activity/activity")
@Api(value = "/manager/activity/activity", tags = "活动模块")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @ApiOperation(value = "活动列表", notes = "活动列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<ActivityListItemVO>> list(@Valid @RequestBody SearchActivityListForm form) {
        return ResultUtils.success(activityService.listActivity(form));
    }

}
