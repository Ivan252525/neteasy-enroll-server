package com.neteasy.server.modules.activity.vo;

import com.neteasy.server.modules.business.vo.PreBusinessVO;

public class ActivityInfoViewVO {

    private ActivityInfoVO activityInfo;

    private PreBusinessVO business;

    public ActivityInfoVO getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(ActivityInfoVO activityInfo) {
        this.activityInfo = activityInfo;
    }

    public PreBusinessVO getBusiness() {
        return business;
    }

    public void setBusiness(PreBusinessVO business) {
        this.business = business;
    }
}
