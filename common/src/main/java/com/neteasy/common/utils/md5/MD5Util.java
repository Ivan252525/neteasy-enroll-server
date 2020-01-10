package com.neteasy.common.utils.md5;


import com.neteasy.common.utils.string.StringUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密工具
 * @author Shao.x
 * @date 2018年8月25日
 */
public class MD5Util {
    public static Logger log = LoggerFactory.getLogger(MD5Util.class);
    private static final String KEY = "2018k23ndls3k4jo*&lgq43j(#*nke5ty%(*6uyalkg45q0420";

    private MD5Util() {}

    /**
     * 自定义MD5  md5(Base64 + KEY)
     * 编码：utf-8
     * @param string
     * @return
     */
    public static String md5(String string) {
        string = clientEncode(string);
        return md5Encode(string + KEY);
    }

    private static String clientEncode(String string) {
        if (StringUtils.isEmpty(string)) {
            return "";
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(string.getBytes("utf-8"));
            byte[] encode = Base64.encodeBase64(digest);
            return new String(encode, "utf-8");
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return string;
    }

    private final static String md5Encode(final String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes("utf-8"));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if(i<0) i+= 256;
                if(i<16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            md.reset();
            return buf.toString().toLowerCase();//32位的加密
        } catch (NoSuchAlgorithmException e) {
            log.error("系统加密异常" + e);
        } catch (UnsupportedEncodingException e) {
            log.error("系统加密异常编码" + e);
        }
        return null;
    }

    public static void main(String[] args) {
        String md5mac=md5("0200 190011 0.3 20160114113301 113301 REFERENCE 302020000114 20160114113301 123456");
        System.out.println(md5mac);
    }
}
