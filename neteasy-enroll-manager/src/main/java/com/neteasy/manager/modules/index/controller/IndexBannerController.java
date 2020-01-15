package com.neteasy.manager.modules.index.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import com.neteasy.manager.modules.index.entity.IndexBannerEntity;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBannerForm;
import com.neteasy.manager.modules.index.service.IndexBannerService;
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
@RequestMapping("/manager/index/banner")
@Api(value = "/manager/index/banner", tags = "首页banner模块")
public class IndexBannerController {

    @Autowired
    IndexBannerService indexBannerService;

    @ApiOperation(value = "banner列表", notes = "banner列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<IndexBannerListItemVO>> list(@Valid @RequestBody PageForm form) {
        return ResultUtils.success(indexBannerService.listIndexBanner(form));
    }

    @ApiOperation(value = "获取banner", notes = "获取banner")
    @GetMapping("/get/{indexBannerId}")
    @Login
    public BaseResult<IndexBannerEntity> list(@PathVariable Long indexBannerId) {
        return ResultUtils.success(indexBannerService.getById(indexBannerId));
    }

    @ApiOperation(value = "新增或修改banner", notes = "新增或修改banner")
    @PostMapping("/addorupdate")
    @Login
    public BaseResult add(@Valid @RequestBody AddOrUpdateIndexBannerForm form,
                          @ApiIgnore @RequestAttribute SysUserEntity sysUserEntity) {
        indexBannerService.addOrUpdate(form, sysUserEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "删除banner", notes = "删除banner")
    @PostMapping("/remove/{indexBannerId}")
    @Login
    public BaseResult remove(@PathVariable Long indexBannerId) {
        indexBannerService.removeById(indexBannerId);
        return ResultUtils.success();
    }

}
