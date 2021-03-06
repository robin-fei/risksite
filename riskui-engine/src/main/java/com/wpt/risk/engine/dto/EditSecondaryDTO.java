package com.wpt.risk.engine.dto;

import com.wpt.risk.base.surpport.DelStatus;

import javax.validation.constraints.NotNull;

public class EditSecondaryDTO extends NewSecondaryDTO {

    @NotNull(message = "{validate.secondary.id}")
    private Integer id;

    private DelStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DelStatus getStatus() {
        return status;
    }

    public void setStatus(DelStatus status) {
        this.status = status;
    }
}