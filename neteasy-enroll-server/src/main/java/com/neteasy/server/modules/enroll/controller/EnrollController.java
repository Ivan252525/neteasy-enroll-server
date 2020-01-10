package com.neteasy.server.modules.enroll.controller;

import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.server.modules.business.vo.BusinessInfoVO;
import com.neteasy.server.modules.enroll.form.CancelEnrollForm;
import com.neteasy.server.modules.enroll.form.EnrollForm;
import com.neteasy.server.modules.enroll.service.UserEnrollService;
import com.neteasy.server.modules.enroll.vo.PreUserEnroll;
import com.neteasy.server.modules.enroll.vo.UserEnrollInfoVO;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/server/enroll/enroll")
@Api(value = "/server/enroll/enroll", tags = "报名模块")
public class EnrollController {

    @Autowired
    UserEnrollService userEnrollService;

    @ApiOperation(value = "用户提交报名信息", notes = "用户提交报名信息")
    @PostMapping("/enroll")
    @Login
    public BaseResult enroll(@Valid @RequestBody EnrollForm form,
                             @ApiIgnore @RequestAttribute UserEntity userEntity) {
        userEnrollService.userEnroll(form, userEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "用户报名列表", notes = "用户报名列表")
    @GetMapping("/list")
    @Login
    public BaseResult<List<PreUserEnroll>> list(@ApiIgnore @RequestAttribute UserEntity userEntity) {
        return ResultUtils.success(userEnrollService.listPreUserEnroll(userEntity.getId()));
    }

    @ApiOperation(value = "用户报名详情", notes = "用户报名详情")
    @GetMapping("/info/{userEnrollId}")
    @Login
    public BaseResult<UserEnrollInfoVO> list(@PathVariable Long userEnrollId) {
        return ResultUtils.success(userEnrollService.getUserEnrollInfo(userEnrollId));
    }

    @ApiOperation(value = "用户取消报名", notes = "用户取消报名")
    @PostMapping("/cancel")
    @Login
    public BaseResult cancel(@Valid @RequestBody CancelEnrollForm form,
                             @ApiIgnore @RequestAttribute UserEntity userEntity) {
        userEnrollService.cancelEnroll(form, userEntity);
        return ResultUtils.success();
    }

}
