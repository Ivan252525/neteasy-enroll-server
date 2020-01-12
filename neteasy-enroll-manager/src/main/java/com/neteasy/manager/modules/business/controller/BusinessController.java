package com.neteasy.manager.modules.business.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.manager.modules.business.entity.BusinessEntity;
import com.neteasy.manager.modules.business.form.AddOrUpdateBusinessForm;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.service.BusinessService;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import com.neteasy.manager.modules.sys.bean.LoginSession;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import com.neteasy.manager.modules.sys.form.LoginForm;
import com.neteasy.manager.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/business/business")
@Api(value = "/manager/business/business", tags = "商家模块")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @ApiOperation(value = "商家列表", notes = "商家列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<BusinessListItemVO>> list(@Valid @RequestBody ListBusinessForm form) {
        return ResultUtils.success(businessService.listBusiness(form));
    }

    @ApiOperation(value = "新增商家", notes = "新增商家")
    @PostMapping("/add")
    @Login
    public BaseResult add(@Valid @RequestBody AddOrUpdateBusinessForm form,
                          @ApiIgnore @RequestAttribute SysUserEntity sysUserEntity) {
        businessService.addBusiness(form, sysUserEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "获取商家", notes = "获取商家")
    @GetMapping("/info/{businessId}")
    @Login
    public BaseResult<BusinessEntity> info(@PathVariable Long businessId) {
        return ResultUtils.success(businessService.getById(businessId));
    }

    @ApiOperation(value = "修改商家", notes = "修改商家")
    @PostMapping("/edit")
    @Login
    public BaseResult edit(@Valid @RequestBody AddOrUpdateBusinessForm form) {
        businessService.editBusiness(form);
        return ResultUtils.success();
    }

    @ApiOperation(value = "删除商家", notes = "删除商家")
    @PostMapping("/remove/{businessId}")
    @Login
    public BaseResult remove(@PathVariable Long businessId) {
        businessService.removeBusiness(businessId);
        return ResultUtils.success();
    }
}
