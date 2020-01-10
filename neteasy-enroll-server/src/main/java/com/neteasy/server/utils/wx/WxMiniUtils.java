package com.neteasy.server.utils.wx;

import com.alibaba.fastjson.JSON;
import com.neteasy.common.utils.http.HttpUtils;
import com.neteasy.common.utils.string.StringUtils;
import com.neteasy.server.NeteasyEnrollServerApplication;
import com.neteasy.server.utils.wx.bean.WxMiniSession;
import com.neteasy.server.utils.wx.bean.WxUserInfo;
import com.neteasy.server.web.config.wx.WxMiniConfig;
import com.neteasy.server.web.exception.BaseException;
import com.neteasy.server.web.exception.message.ErrorInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 小程序工具类
 *
 */
public class WxMiniUtils {

    static final Logger log = LoggerFactory.getLogger(WxMiniUtils.class);

    private final static WxMiniConfig wxMiniConfig = NeteasyEnrollServerApplication.applicationContext.getBean(WxMiniConfig.class);

    /**
     * 小程序登录
     *
     * @param code
     * @return
     */
    public static WxMiniSession code2session(String code) {
        WxMiniSession wxMiniSession;
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session";
            String s = HttpUtils.sendGet(url,
                    "appid=" + wxMiniConfig.getAppId() + "&secret=" + wxMiniConfig.getAppSecret() + "&js_code=" + code + "&grant_type=authorization_code");
            log.info("小程序登录接口返回：" + s);
            wxMiniSession = JSON.parseObject(s, WxMiniSession.class);
            if (StringUtils.isEmpty(wxMiniSession.getSessionKey()) || StringUtils.isEmpty(wxMiniSession.getOpenId())) {
                throw new BaseException(ErrorInfo.WX_CODE2SESSION_ERROR);
            }
        } catch (Exception e) {
            log.error("", e);
            throw new BaseException(ErrorInfo.WX_CODE2SESSION_ERROR);
        }
        return wxMiniSession;
    }

    /**
     * 校验用户信息
     *
     * @param rawData
     * @param signature
     * @param sessionKey
     * @return
     */
    public static WxUserInfo checkAndParseUserInfo(String rawData, String signature, String sessionKey) {
        String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
        if (!signature.equals(signature2)) {
            throw new BaseException(ErrorInfo.WX_DATA_CHECK_ERROR);
        }
        return JSON.parseObject(rawData, WxUserInfo.class);
    }

}
