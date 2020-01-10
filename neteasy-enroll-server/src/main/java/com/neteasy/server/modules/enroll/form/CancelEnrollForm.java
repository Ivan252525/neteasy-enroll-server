package com.neteasy.server.modules.enroll.form;

public class CancelEnrollForm {

    private Long enrollId;

    private String reason;

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
