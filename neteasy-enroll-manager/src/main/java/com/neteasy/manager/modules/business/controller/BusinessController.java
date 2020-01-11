package com.neteasy.manager.modules.business.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.manager.modules.business.entity.BusinessEntity;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.service.BusinessService;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import com.neteasy.manager.modules.sys.bean.LoginSession;
import com.neteasy.manager.modules.sys.form.LoginForm;
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
@RequestMapping("/manager/business/business")
@Api(value = "/manager/business/business", tags = "商家模块")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @ApiOperation(value = "商家列表", notes = "商家列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<BusinessListItemVO>> login(@Valid @RequestBody ListBusinessForm form) {
        return ResultUtils.success(businessService.listBusiness(form));
    }

}
