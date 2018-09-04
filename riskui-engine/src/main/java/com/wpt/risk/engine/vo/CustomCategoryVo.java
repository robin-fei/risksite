package com.wpt.risk.engine.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomCategoryVo implements Serializable {

    private Integer customCategoryId;
    private String customCategory;
}