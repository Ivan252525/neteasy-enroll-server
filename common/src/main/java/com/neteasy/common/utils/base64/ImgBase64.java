package com.neteasy.common.utils.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;

public class ImgBase64 {

    /**
     * @param imgStr base64编码字符串
     * @return
     * @Description: 将base64编码字符串转换为图片
     * @Author:
     * @CreateTime:
     */
    public static byte[] generateImage(String imgStr) {
        if (imgStr == null) {
            throw new RuntimeException("base64字符串不能为空");
        };
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = Base64.decodeBase64(imgStr.getBytes());
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return b;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @return
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     */
    public static String getImageStr(InputStream imgFile) {
        byte[] data = null;
        try {
            data = new byte[imgFile.available()];
            imgFile.read(data);
            imgFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
