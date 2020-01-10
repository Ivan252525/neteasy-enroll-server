package com.neteasy.server.modules.index.controller;

import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.server.modules.activity.vo.PreActivityVO;
import com.neteasy.server.modules.index.service.IndexService;
import com.neteasy.server.modules.index.vo.IndexVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/server/index/index")
@Api(value = "/server/index/index", tags = "活动模块")
public class IndexController {

    @Autowired
    IndexService indexService;

    @ApiOperation(value = "首页数据", notes = "首页数据")
    @GetMapping("/data")
    public BaseResult<IndexVO> indexData() {
        return ResultUtils.success(indexService.getIndexData());
    }

}
