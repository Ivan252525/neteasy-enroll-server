package com.neteasy.manager.modules.file.controller;

import com.github.pagehelper.PageInfo;
import com.neteasy.common.web.BaseResult;
import com.neteasy.common.web.ResultUtils;
import com.neteasy.manager.modules.business.form.ListBusinessForm;
import com.neteasy.manager.modules.business.vo.BusinessListItemVO;
import com.neteasy.manager.modules.file.service.FileService;
import com.neteasy.manager.web.annotation.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/file/file")
@Api(value = "/manager/file/file", tags = "商家模块")
public class FileController {

    @Autowired
    FileService fileService;

    @ApiOperation(value = "上传二进图片", notes = "上传二进图片")
    @PostMapping("/upload/multipart")
    @Login
    public BaseResult<String> login(MultipartFile file) {
        return ResultUtils.success(fileService.uploadMultipartFile(file));
    }

}
