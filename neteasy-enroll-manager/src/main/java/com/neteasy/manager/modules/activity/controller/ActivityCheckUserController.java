package com.neteasy.manager.modules.activity.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.manager.modules.activity.form.ListCheckUserForm;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.service.ActivityCheckUserService;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import com.neteasy.manager.modules.activity.vo.CheckUserListItemVO;
import com.neteasy.manager.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/activity/check")
@Api(value = "/manager/activity/check", tags = "核销人模块")
public class ActivityCheckUserController {

    @Autowired
    ActivityCheckUserService activityCheckUserService;

    @ApiOperation(value = "核销人列表", notes = "核销人列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<CheckUserListItemVO>> list(@Valid @RequestBody ListCheckUserForm form) {
        return ResultUtils.success(activityCheckUserService.listCheckUser(form));
    }

    @ApiOperation(value = "移除核销人", notes = "移除核销人")
    @PostMapping("/remove/{id}")
    @Login
    public BaseResult remove(@PathVariable Long id) {
        return ResultUtils.success(activityCheckUserService.removeById(id));
    }

}
