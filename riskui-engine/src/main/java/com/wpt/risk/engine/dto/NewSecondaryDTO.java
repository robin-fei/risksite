package com.wpt.risk.engine.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class NewSecondaryDTO implements Serializable {

    @NotNull(message = "{validate.secondary.sourceId}")
    private Integer sourceId;
    @NotNull(message = "{validate.secondary.familyId}")
    private Integer familyId;
    @NotBlank(message = "{validate.secondary.fieldName}")
    private String fieldName;
    @NotBlank(message = "{validate.secondary.cnName}")
    private String cnName;
    private String notes;

}