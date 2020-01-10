package com.neteasy.common.utils.sms;

public enum SmsType {
	REGISTER("SMS_174185514","注册"),
	CHANGE_PW("SMS_174185513","修改密码"),
	LOGIN_ERR("SMS_174185515","登录异常(异地登录)"),
	LOGIN_CHECK("SMS_174185516","登录确认"),
	CHANGE_INFO("SMS_174185512","信息变更"),
	ID_CHECK("SMS_174185517","身份验证")
	;
	private String code;
	private String desc;
	
	SmsType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
