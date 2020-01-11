package com.neteasy.manager.modules.file.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 上传二进制图片
     *
     * @param file
     * @return
     */
    String uploadMultipartFile(MultipartFile file);

}
