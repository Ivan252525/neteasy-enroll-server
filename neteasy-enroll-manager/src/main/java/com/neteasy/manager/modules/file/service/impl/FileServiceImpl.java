package com.neteasy.manager.modules.file.service.impl;

import com.neteasy.manager.modules.file.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    final static String IMAGE_LOCAL_PATH = "/mnt/neteasy/images/";

    @Override
    public String uploadMultipartFile(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString().replace("-", "") +
                    "." + originalFilename.split("\\.")[1];

            OutputStream out = new FileOutputStream(IMAGE_LOCAL_PATH + fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
            return "https://www.weselfshop.cn/enroll-image/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
