package com.neteasy.server.modules.user.form;

import javax.validation.constraints.NotNull;

public class InitWxUserForm {

    @NotNull
    private String nickname;

    @NotNull
    private Integer sex;

    @NotNull
    private String userLogo;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }
}
