package com.neteasy.common.utils.image;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class ImageUtils {

    public static ByteArrayOutputStream resize(BufferedImage orgImage, float scale, float quality) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Thumbnails.of(orgImage).scale(scale).outputQuality(quality).outputFormat("png").toOutputStream(out);
            return out;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
