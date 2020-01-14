package com.neteasy.manager.modules.activity.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.manager.modules.activity.entity.ActivityEntity;
import com.neteasy.manager.modules.activity.form.AddActivityForm;
import com.neteasy.manager.modules.activity.form.SearchActivityListForm;
import com.neteasy.manager.modules.activity.service.ActivityService;
import com.neteasy.manager.modules.activity.vo.ActivityInfoVO;
import com.neteasy.manager.modules.activity.vo.ActivityListItemVO;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import com.neteasy.manager.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/manager/activity/activity")
@Api(value = "/manager/activity/activity", tags = "活动模块")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @ApiOperation(value = "活动列表", notes = "活动列表")
    @PostMapping("/list")
    @Login
    public BaseResult<PageInfo<ActivityListItemVO>> list(@Valid @RequestBody SearchActivityListForm form) {
        return ResultUtils.success(activityService.listActivity(form));
    }

    @ApiOperation(value = "新增活动", notes = "新增活动")
    @PostMapping("/add")
    @Login
    public BaseResult add(@Valid @RequestBody AddActivityForm form,
                          @ApiIgnore @RequestAttribute SysUserEntity sysUserEntity) {
        activityService.addActivity(form, sysUserEntity);
        return ResultUtils.success();
    }

    @ApiOperation(value = "获取活动", notes = "获取活动")
    @GetMapping("/get/{activityId}")
    @Login
    public BaseResult<ActivityInfoVO> get(@PathVariable Long activityId) {
        return ResultUtils.success(activityService.getActivityInfo(activityId));
    }

    @ApiOperation(value = "下载报名名单Excel", notes = "下载报名名单Excel")
    @GetMapping("/excel/enroll/{activityId}")
    public void enrollExcel(@PathVariable Long activityId,
                            HttpServletResponse response) throws IOException {
        HSSFWorkbook enrollExcel = activityService.getEnrollExcel(activityId);

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("报名名单.xls", "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        enrollExcel.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
