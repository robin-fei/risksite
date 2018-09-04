package com.wpt.risk.base.utils;

import java.io.Serializable;

public interface ValueAsignEnumeration<T, E> extends Serializable {

    String name();

    T codeVal();

    String strVal();

    E fromJSON(String code);
}