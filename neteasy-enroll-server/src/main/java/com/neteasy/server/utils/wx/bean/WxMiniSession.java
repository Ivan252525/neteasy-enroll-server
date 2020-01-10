package com.neteasy.server.utils.wx.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class WxMiniSession {

    @JSONField(name = "session_key")
    private String sessionKey;

    @JSONField(name = "openid")
    private String openId;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
