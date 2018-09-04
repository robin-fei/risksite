package com.wpt.risk.engine.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpt.risk.base.surpport.Behavior;
import com.wpt.risk.base.surpport.CorrectStatus;
import com.wpt.risk.base.surpport.PayStatus;
import com.wpt.risk.base.surpport.ResultStatus;
import com.wpt.risk.base.utils.TimeStamps2StringSerializer;

import java.io.Serializable;

public class EventVo implements Serializable {

    private Long userId;
    private Behavior behavior;
    private String itemUrl;
    @JsonSerialize(using = TimeStamps2StringSerializer.class)
    private Long time;
    private Integer percentage;
    private PayStatus payStatus;
    private CorrectStatus correctStatus;
    private ResultStatus resultStatus;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public PayStatus getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(PayStatus payStatus) {
        this.payStatus = payStatus;
    }

    public CorrectStatus getCorrectStatus() {
        return correctStatus;
    }

    public void setCorrectStatus(CorrectStatus correctStatus) {
        this.correctStatus = correctStatus;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}