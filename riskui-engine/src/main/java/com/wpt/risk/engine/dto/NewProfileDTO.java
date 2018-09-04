package com.wpt.risk.engine.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class NewProfileDTO implements Serializable {

    @NotNull(message = "{validate.profile.sourceId}")
    private Integer sourceId;
    @NotNull(message = "{validate.profile.familyId}")
    private Integer familyId;
    @NotNull(message = "{validate.profile.secondaryId}")
    private Integer secondFamilyId;
    @NotBlank(message = "{validate.profile.fieldName}")
    private String fieldName;
    @NotBlank(message = "{validate.profile.cnName}")
    private String cnName;
    @NotBlank(message = "{validate.profile.fieldType}")
    private String fieldType;
    private String notes;
}