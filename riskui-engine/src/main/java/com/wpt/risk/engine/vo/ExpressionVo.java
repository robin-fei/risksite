package com.wpt.risk.engine.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExpressionVo implements Serializable {

    private Integer expressionId;
    private String expression;
}