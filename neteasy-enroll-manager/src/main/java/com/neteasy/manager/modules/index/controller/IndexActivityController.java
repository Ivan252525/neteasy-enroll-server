package com.neteasy.manager.modules.index.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexActivityEntity;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexActivityForm;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBannerForm;
import com.neteasy.manager.modules.index.service.IndexActivityService;
import com.neteasy.manager.modules.index.vo.IndexActivityListItemVO;
import com.neteasy.manager.modules.index.vo.IndexBannerListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import com.neteasy.manager.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/index/activity")
@Api(value = "/manager/index/activity", tags = "首页活动模块")
public class IndexActivityController {

    @Autowired
    IndexActivityService indexActivityService;

    @ApiOperation(value = "首页活动列表", notes = "首页活动列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<IndexActivityListItemVO>> list(@Valid @RequestBody PageForm form) {
        return ResultUtils.success(indexActivityService.listIndexActivity(form));
    }

    @ApiOperation(value = "获取首页活动", notes = "获取首页活动")
    @GetMapping("/get/{indexActivityId}")
    @Login
    public BaseResult<IndexActivityEntity> get(@PathVariable Long indexActivityId) {
        return ResultUtils.success(indexActivityService.getById(indexActivityId));
    }

    @ApiOperation(value = "新增或修改首页活动", notes = "新增或修改首页活动")
    @PostMapping("/addorupdate")
    @Login
    public BaseResult add(@Valid @RequestBody AddOrUpdateIndexActivityForm form,
                          @ApiIgnore @RequestAttribute SysUserEntity sysUserEntity) {
        indexActivityService.addOrUpdateIndexActivity(form, sysUserEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "删除首页活动", notes = "删除首页活动")
    @PostMapping("/remove/{indexActivityId}")
    @Login
    public BaseResult remove(@PathVariable Long indexActivityId) {
        indexActivityService.removeById(indexActivityId);
        return ResultUtils.success();
    }

}
