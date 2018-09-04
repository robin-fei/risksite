package com.wpt.risk.engine.dto;

import com.wpt.risk.base.surpport.LogicSymbol;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Data
public class WhenDTO implements Serializable {
    private List<ExpressionDTO> expressionDTOs;
    private LogicSymbol symbol;
    @NotBlank(message = "validate.custom.result")
    private String result;
}