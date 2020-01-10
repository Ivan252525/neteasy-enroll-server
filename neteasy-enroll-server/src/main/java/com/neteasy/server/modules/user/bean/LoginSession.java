package com.neteasy.server.modules.user.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.neteasy.server.modules.user.entity.UserEntity;

/**
 * @author: Ivan
 * @date: 2019/1/22 08:57
 */
public class LoginSession {

    private String token;

    private Long expireIn;

    private UserEntity userInfo;

    @JSONField(serialize = false)
    private String wxSessionKey;

    private Boolean isInit;

    public Boolean getInit() {
        return isInit;
    }

    public void setInit(Boolean init) {
        isInit = init;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Long expireIn) {
        this.expireIn = expireIn;
    }

    public UserEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserEntity userInfo) {
        this.userInfo = userInfo;
    }

    public String getWxSessionKey() {
        return wxSessionKey;
    }

    public void setWxSessionKey(String wxSessionKey) {
        this.wxSessionKey = wxSessionKey;
    }
}
