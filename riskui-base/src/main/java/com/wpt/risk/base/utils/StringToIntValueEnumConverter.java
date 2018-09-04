//package com.wpt.risk.base.utils;
//
//import org.springframework.core.convert.converter.Converter;
//
//public class StringToIntValueEnumConverter<T extends ValueAsignEnumeration> implements Converter<String, T> {
//
//    private final Class<T> enumType;
//
//    public StringToIntValueEnumConverter(Class<T> enumType) {
//        this.enumType = enumType;
//    }
//
//    public T convert(String source) {
//        if (source.length() == 0) {
//            // It's an empty enum identifier: reset the enum value to null.
//            return null;
//        }
//
//        T[] all = enumType.getEnumConstants();
//        for (T t : all) {
//            if (source.equals(t.codeVal()))
//                return t;
//            if (source.equals(t.name()))
//                return t;
//        }
//        return null;
//    }
//}