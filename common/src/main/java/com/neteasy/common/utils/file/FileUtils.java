package com.neteasy.common.utils.file;

import java.io.FileOutputStream;

public class FileUtils {

    public static void saveByte(byte[] bytes, String path) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
