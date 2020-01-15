package com.neteasy.server.web.exception.message;

public enum ErrorInfo {

    NOT_LOGIN(401, "没有登陆或登陆信息过期"),

    // 操作性错误
    MISS_PARAM(1001, "参数缺失或参数格式错误"),
    PATH_NOT_FOUNT(1002, "路径不存在"),

    // 业务错误
    WX_CODE2SESSION_ERROR(2001, "获取小程序登录会话失败"),
    WX_DATA_CHECK_ERROR(2002, "微信数据校验错误"),
    USER_ALREADY_ENROLL(2003, "用户已经报名该活动"),
    ACTIVITY_DELETED(2004, "活动已下架"),
    BUSINESS_DELETED(2005, "商家不存在"),

    // 数据库等错误
    UNKNOWN_ERROR(3001, "系统错误"),
    NETWORK_ERROR(3002, "网络错误"),
    PERMIT_ERROR(3003, "权限错误"), 
    ;

    private int code;
    private String desc;

    ErrorInfo(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
