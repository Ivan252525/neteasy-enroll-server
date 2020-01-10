package com.neteasy.manager.modules.sys.controller;

import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.manager.modules.sys.bean.LoginSession;
import com.neteasy.manager.modules.sys.form.LoginForm;
import com.neteasy.manager.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/sys/sys")
@Api(value = "/manager/sys/sys", tags = "系统模块")
public class SysController {

    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value = "后台用户登录", notes = "后台用户登录")
    @PostMapping("/login")
    public BaseResult<LoginSession> login(@Valid @RequestBody LoginForm form) {
        return ResultUtils.success(sysUserService.login(form));
    }

}
