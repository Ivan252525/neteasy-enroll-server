package com.neteasy.server.modules.business.controller;

import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.server.modules.business.service.BusinessService;
import com.neteasy.server.modules.business.vo.BusinessInfoVO;
import com.neteasy.server.modules.business.vo.PreBusinessVO;
import com.neteasy.server.modules.user.entity.UserEntity;
import com.neteasy.server.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/server/business/business")
@Api(value = "/server/business/business", tags = "商家模块")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @ApiOperation(value = "获取商家详情", notes = "获取商家详情")
    @GetMapping("/info/{businessId}")
    public BaseResult<BusinessInfoVO> getBusinessInfo(@PathVariable Long businessId,
                                                      @ApiIgnore @RequestAttribute(required = false) UserEntity userEntity) {
        return ResultUtils.success(businessService.getBusinessInfo(businessId, userEntity));
    }

    @ApiOperation(value = "关注或取关商家", notes = "关注或取关商家")
    @PostMapping("/likeorremove/{businessId}")
    @Login
    public BaseResult likeOrRemoveLike(@PathVariable Long businessId,
                                                       @ApiIgnore @RequestAttribute UserEntity userEntity) {
        businessService.likeOrRemoveLike(businessId, userEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "获取用户关注商家列表", notes = "获取用户关注商家列表")
    @GetMapping("/listuserlike")
    @Login
    public BaseResult<List<PreBusinessVO>> listUserLikeBusiness(@ApiIgnore @RequestAttribute UserEntity userEntity) {
        return ResultUtils.success(businessService.listUserLikeBusiness(userEntity));
    }

}
