package com.wpt.risk.engine.dto;

import com.wpt.risk.base.surpport.Behavior;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class EventDTO extends BaseDTO {

    @NotNull(message = "{validate.uid}")
    private Long uid;

    private Date beginDate;
    private Date endDate;
    private Behavior behavior;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "uid=" + uid +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", behavior=" + behavior +
                '}';
    }
}