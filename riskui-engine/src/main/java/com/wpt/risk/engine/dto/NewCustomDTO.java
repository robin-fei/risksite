package com.wpt.risk.engine.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class NewCustomDTO {

    @NotNull(message = "validate.custom.sourceId")
    private Integer sourceId;
    private String source;
    @NotNull(message = "validate.custom.customCategoryId")
    private Integer customCategoryId;
    private String customCategoryName;
    @NotBlank(message = "{validate.custom.labelName}")
    private String labelName;
    private String values;
    private String notes;
    private String caseClause;
    private String labelField;
    private String expJson;

    private List<WhenDTO> whenDTOs;
}