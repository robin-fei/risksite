package com.wpt.risk.base.surpport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationDeserializer;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationSerializer;
import com.wpt.risk.base.utils.ValueAsignEnumeration;

@JsonSerialize(using = JacksonValueAssignEnumerationSerializer.class)
@JsonDeserialize(using = JacksonValueAssignEnumerationDeserializer.class)
public enum ResultStatus implements ValueAsignEnumeration<String, ResultStatus> {
    //    result： canpay  | fail    | nopay   | pay
//    可能支付|违约|未支付|支付
    CAN_PAY("canpay", "可能支付"),
    FAIL("fail", "违约"),
    NO_PAY("nopay", "违约"),
    PAY("pay", "支付"),
    NULL("null", "未成拍"),
    BLANK("", "未成拍"),;


    private String code;
    private String name;

    ResultStatus(String code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static ResultStatus getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (ResultStatus b : values()) {
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
    public ResultStatus fromJSON(String code) {
        return getByCode(code);
    }


}