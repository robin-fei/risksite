package com.wpt.risk.engine.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaVo implements Serializable {

    private Integer sourceId;
    private String source;
    private String cnSource;
}