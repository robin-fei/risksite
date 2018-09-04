package com.wpt.risk.engine.dto;

public class SearchDTO extends BaseDTO {

    private String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "fieldName='" + fieldName + '\'' +
                '}';
    }
}