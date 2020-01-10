package com.neteasy.common.utils.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {

    final static Logger log = LoggerFactory.getLogger(StreamUtils.class);

    public static InputStream bufferedImageToInputStream(BufferedImage image, String formatName) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, formatName, os);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            log.error("BufferedImage转InputStream失败：", e);
        }
        return null;
    }

    public static byte[] bufferedImageToByteArray(BufferedImage image, String formatName) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, formatName, os);
            return os.toByteArray();
        } catch (IOException e) {
            log.error("BufferedImage转字节数组失败：", e);
        }
        return null;
    }

}
