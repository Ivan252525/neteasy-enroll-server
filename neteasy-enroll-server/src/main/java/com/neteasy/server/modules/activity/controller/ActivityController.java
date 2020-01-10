package com.neteasy.server.modules.activity.controller;

import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.server.modules.activity.service.ActivityService;
import com.neteasy.server.modules.activity.vo.ActivityFormItemVO;
import com.neteasy.server.modules.activity.vo.ActivityInfoViewVO;
import com.neteasy.server.modules.activity.vo.PreActivityVO;
import com.neteasy.server.modules.business.vo.BusinessInfoVO;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/server/activity/activity")
@Api(value = "/server/activity/activity", tags = "活动模块")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @ApiOperation(value = "活动列表", notes = "活动列表")
    @GetMapping("/list/{enrollState}/{jmRegionId}")
    public BaseResult<List<PreActivityVO>> listActivity(@PathVariable Integer enrollState,
                                                        @PathVariable Long jmRegionId) {
        return ResultUtils.success(activityService.listActivity(enrollState, jmRegionId));
    }

    @ApiOperation(value = "活动详情", notes = "活动详情")
    @GetMapping("/info/{activityId}")
    public BaseResult<ActivityInfoViewVO> getActivity(@PathVariable Long activityId,
                                                      @ApiIgnore @RequestAttribute(required = false) UserEntity userEntity) {
        return ResultUtils.success(activityService.getActivityInfo(activityId, userEntity));
    }

    @ApiOperation(value = "收藏或取消收藏", notes = "收藏或取消收藏")
    @PostMapping("/collectorremove/{activityId}")
    @Login
    public BaseResult collectOrRemove(@PathVariable Long activityId,
                                      @ApiIgnore @RequestAttribute UserEntity userEntity) {
        activityService.collectOrRemove(activityId, userEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "报名表单", notes = "报名表单")
    @GetMapping("/form/{activityId}")
    public BaseResult<List<ActivityFormItemVO>> getActivityForm(@PathVariable Long activityId) {
        return ResultUtils.success(activityService.listActivityFormItem(activityId));
    }

    @ApiOperation(value = "活动列表", notes = "活动列表")
    @GetMapping("/listusercollect")
    @Login
    public BaseResult<List<PreActivityVO>> listActivity(@ApiIgnore @RequestAttribute UserEntity userEntity) {
        return ResultUtils.success(activityService.listUserCollect(userEntity));
    }

}
