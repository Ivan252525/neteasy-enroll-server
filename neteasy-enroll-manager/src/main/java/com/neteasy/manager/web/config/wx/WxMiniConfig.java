package com.neteasy.manager.web.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WxMiniConfig {

    @Value("${wx.mini.appId}")
    private String appId;

    @Value("${wx.mini.appSecret}")
    private String appSecret;

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }
}
