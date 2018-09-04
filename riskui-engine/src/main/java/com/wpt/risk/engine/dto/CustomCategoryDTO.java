package com.wpt.risk.engine.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Data
public class CustomCategoryDTO implements Serializable {
    @NotBlank(message = "{validate.custom.categoryName}")
    private String categoryName;
    private Integer categoryId;
}