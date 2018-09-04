package com.wpt.risk.base.surpport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationDeserializer;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationSerializer;
import com.wpt.risk.base.utils.ValueAsignEnumeration;

@JsonSerialize(using = JacksonValueAssignEnumerationSerializer.class)
@JsonDeserialize(using = JacksonValueAssignEnumerationDeserializer.class)
public enum PayStatus implements ValueAsignEnumeration<String, PayStatus> {
    //    status：canpay  | lowpay    | nopay     | null      | willpay
//    可能支付|低概率支付|不会支付|未知|会支付
    CAN_PAY("canpay", "可能支付"),
    LOW_PAY("lowpay", "低概率支付"),
    NO_PAY("nopay", "不会支付"),
    NULL("null", "未知"),
    BLANK("", "未知"),
    WILL_PAY("willpay", "会支付"),;


    private String code;
    private String name;

    PayStatus(String code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static PayStatus getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (PayStatus b : values()) {
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
    public PayStatus fromJSON(String code) {
        return getByCode(code);
    }


}