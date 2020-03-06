package com.neteasy.server.modules.enroll.vo;

public class CheckCodeInfoVO {

    private String businessLogo;

    private String activityTitle;

    private String checkCode;

    private String checkCodePart1;

    private String checkCodePart2;

    private String checkCodePart3;

    private Integer checkState;

    private String checkTime;

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getCheckCodePart1() {
        return checkCodePart1;
    }

    public void setCheckCodePart1(String checkCodePart1) {
        this.checkCodePart1 = checkCodePart1;
    }

    public String getCheckCodePart2() {
        return checkCodePart2;
    }

    public void setCheckCodePart2(String checkCodePart2) {
        this.checkCodePart2 = checkCodePart2;
    }

    public String getCheckCodePart3() {
        return checkCodePart3;
    }

    public void setCheckCodePart3(String checkCodePart3) {
        this.checkCodePart3 = checkCodePart3;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }
}
