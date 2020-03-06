package com.neteasy.server.modules.user.vo;

public class UserDataVO {

    private Integer likeNum;

    private Integer collectNum;

    private Integer showCheck;

    public Integer getShowCheck() {
        return showCheck;
    }

    public void setShowCheck(Integer showCheck) {
        this.showCheck = showCheck;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }
}
