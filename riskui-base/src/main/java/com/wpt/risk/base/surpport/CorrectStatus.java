package com.wpt.risk.base.surpport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationDeserializer;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationSerializer;
import com.wpt.risk.base.utils.ValueAsignEnumeration;

@JsonSerialize(using = JacksonValueAssignEnumerationSerializer.class)
@JsonDeserialize(using = JacksonValueAssignEnumerationDeserializer.class)
public enum CorrectStatus implements ValueAsignEnumeration<String, CorrectStatus> {

    //    ISCORRECT： | null       | -1         | 0          | 1
//    未知|未知|错误|正确
    NULL("null", "未知"),
    BLANK("", "未知"),
    NEG1("-1", "未知"),
    ZERO("0", "预测错误"),
    ONE("1", "预测正确"),;


    private String code;
    private String name;

    CorrectStatus(String code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static CorrectStatus getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (CorrectStatus b : values()) {
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
    public CorrectStatus fromJSON(String code) {
        return getByCode(code);
    }


}