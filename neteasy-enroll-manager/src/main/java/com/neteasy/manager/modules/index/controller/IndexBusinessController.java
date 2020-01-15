package com.neteasy.manager.modules.index.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.common.web.page.PageForm;
import com.neteasy.manager.modules.index.entity.IndexActivityEntity;
import com.neteasy.manager.modules.index.entity.IndexBusinessEntity;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexActivityForm;
import com.neteasy.manager.modules.index.form.AddOrUpdateIndexBusinessForm;
import com.neteasy.manager.modules.index.service.IndexActivityService;
import com.neteasy.manager.modules.index.service.IndexBusinessService;
import com.neteasy.manager.modules.index.vo.IndexActivityListItemVO;
import com.neteasy.manager.modules.index.vo.IndexBusinessListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import com.neteasy.manager.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/index/business")
@Api(value = "/manager/index/business", tags = "首页商家模块")
public class IndexBusinessController {

    @Autowired
    IndexBusinessService indexBusinessService;

    @ApiOperation(value = "首页商家列表", notes = "首页商家列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<IndexBusinessListItemVO>> list(@Valid @RequestBody PageForm form) {
        return ResultUtils.success(indexBusinessService.listIndexBusiness(form));
    }

    @ApiOperation(value = "获取首页商家", notes = "获取首页商家")
    @GetMapping("/get/{indexBusinessId}")
    @Login
    public BaseResult<IndexBusinessEntity> get(@PathVariable Long indexBusinessId) {
        return ResultUtils.success(indexBusinessService.getById(indexBusinessId));
    }

    @ApiOperation(value = "新增或修改首页商家", notes = "新增或修改首页商家")
    @PostMapping("/addorupdate")
    @Login
    public BaseResult add(@Valid @RequestBody AddOrUpdateIndexBusinessForm form,
                          @ApiIgnore @RequestAttribute SysUserEntity sysUserEntity) {
        indexBusinessService.addOrUpdateIndexBusiness(form, sysUserEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "删除首页商家", notes = "删除首页商家")
    @PostMapping("/remove/{indexBusinessId}")
    @Login
    public BaseResult remove(@PathVariable Long indexBusinessId) {
        indexBusinessService.removeById(indexBusinessId);
        return ResultUtils.success();
    }

}
