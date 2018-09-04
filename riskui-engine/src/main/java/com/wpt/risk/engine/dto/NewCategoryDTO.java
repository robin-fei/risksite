package com.wpt.risk.engine.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class NewCategoryDTO implements Serializable {

    @NotNull(message = "{validate.category.sourceId}")
    private Integer sourceId;
    @NotBlank(message = "{validate.category.fieldName}")
    private String fieldName;
    @NotBlank(message = "{validate.category.cnName}")
    private String cnName;
    private String notes;
}