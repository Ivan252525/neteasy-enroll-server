package com.neteasy.server.modules.user.controller;

import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.server.modules.user.bean.LoginSession;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.modules.user.form.InitWxUserForm;
import com.neteasy.server.modules.user.form.UpdateUserInfoForm;
import com.neteasy.server.modules.user.service.UserService;
import com.neteasy.server.modules.user.vo.UserDataVO;
import com.neteasy.server.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/server/user/user")
@Api(value = "/server/user/user", tags = "用户模块")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "小程序登陆", notes = "小程序登陆接口")
    @PostMapping("/login/{code}")
    public BaseResult<LoginSession> login(@PathVariable String code) {
        return ResultUtils.success(userService.login(code));
    }

    @ApiOperation(value = "初始化用户", notes = "初始化用户")
    @PostMapping("/init")
    @Login
    public BaseResult<LoginSession> init(@Valid @RequestBody InitWxUserForm form,
                                          @ApiIgnore @RequestAttribute UserEntity userEntity) {
        return ResultUtils.success(userService.initUser(form, userEntity));
    }

    @ApiOperation(value = "获取用户数据", notes = "获取用户数据")
    @GetMapping("/data")
    @Login
    public BaseResult<UserDataVO> data(@ApiIgnore @RequestAttribute UserEntity userEntity) {
        return ResultUtils.success(userService.getUserData(userEntity));
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping("/update")
    @Login
    public BaseResult<LoginSession> update(@Valid @RequestBody UpdateUserInfoForm form,
                                           @ApiIgnore @RequestAttribute UserEntity userEntity) {
        return ResultUtils.success(userService.updateUserInfo(userEntity, form));
    }

}
