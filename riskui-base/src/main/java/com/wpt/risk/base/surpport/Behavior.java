package com.wpt.risk.base.surpport;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationDeserializer;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationSerializer;
import com.wpt.risk.base.utils.ValueAsignEnumeration;


@JsonSerialize(using = JacksonValueAssignEnumerationSerializer.class)
@JsonDeserialize(using = JacksonValueAssignEnumerationDeserializer.class)
public enum Behavior implements ValueAsignEnumeration<String, Behavior> {
    //    Type: bid             |deal            | fail            | refund_residue  | residue
//    出价|成交|违约|退款|支付
    BID("bid", "出价"),
    DEAL("deal", "成交"),
    FAIL("fail", "违约"),
    REFUND_RESIDUE("refund_residue", "退款"),
    RESIDUE("residue", "支付"),;


    private String code;
    private String name;

    Behavior(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public static Behavior getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (Behavior b : values()) {
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
    public Behavior fromJSON(String code) {
        return getByCode(code);
    }


}