package com.wpt.risk.engine.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class ExpressionDTO implements Serializable {

    @NotNull(message = "validate.custom.firstFieldId")
    private Integer firstFieldId;
    @NotNull(message = "validate.custom.secondaryFieldId")
    private Integer secondFieldId;
    @NotNull(message = "validate.custom.profileFieldId")
    private Integer profileFieldId;
    @NotNull(message = "validate.custom.symbolId")
    private Integer symbolId;
    private @NotEmpty(message = "validate.custom.values") List<String> values;

}