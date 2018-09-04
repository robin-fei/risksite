package com.wpt.risk.base.surpport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationDeserializer;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationSerializer;
import com.wpt.risk.base.utils.ValueAsignEnumeration;

@JsonSerialize(using = JacksonValueAssignEnumerationSerializer.class)
@JsonDeserialize(using = JacksonValueAssignEnumerationDeserializer.class)
public enum DelStatus implements ValueAsignEnumeration<Integer, DelStatus> {

    DEL(1, "冻结"),
    UN_DEL(0, "正常"),;


    private Integer code;
    private String name;

    DelStatus(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static DelStatus getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (DelStatus b : values()) {
            if (code == b.codeVal()) {
                return b;
            }
        }

        return null;
    }

    @Override
    public Integer codeVal() {
        return code;
    }

    @Override
    public String strVal() {
        return name;
    }

    @Override
    public DelStatus fromJSON(String code) {
        return getByCode(Integer.parseInt(code));
    }
}