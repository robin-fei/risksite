package com.wpt.risk.base.surpport;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationDeserializer;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationSerializer;
import com.wpt.risk.base.utils.ValueAsignEnumeration;

@JsonSerialize(using = JacksonValueAssignEnumerationSerializer.class)
@JsonDeserialize(using = JacksonValueAssignEnumerationDeserializer.class)
public enum LogicSymbol implements ValueAsignEnumeration<String, LogicSymbol> {

    AND("and", "与"),
    OR("or", "或"),;


    private String code;
    private String name;

    LogicSymbol(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public static LogicSymbol getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (LogicSymbol b : values()) {
            if (code.equals(b.codeVal())) {
                return b;
            }
        }

        return null;
    }

    @Override
    public String codeVal() {
        return code;
    }

    @Override
    public String strVal() {
        return name;
    }

    @Override
    public LogicSymbol fromJSON(String code) {
        return getByCode(code);
    }
}