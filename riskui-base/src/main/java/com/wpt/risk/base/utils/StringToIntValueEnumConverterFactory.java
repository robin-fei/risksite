//package com.wpt.risk.base.utils;
//
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.convert.converter.ConverterFactory;
//
//public class StringToIntValueEnumConverterFactory implements ConverterFactory<String, ValueAsignEnumeration> {
//
//    public <T extends ValueAsignEnumeration> Converter<String, T> getConverter(Class<T> targetType) {
//        if (!targetType.isEnum()) {
//            throw new UnsupportedOperationException("只支持转换到枚举类型");
//        }
//        return new StringToEnum(targetType);
//    }
//
//    private class StringToEnum<T extends ValueAsignEnumeration> implements Converter<String, T> {
//
//        private final Class<T> enumType;
//
//        public StringToEnum(Class<T> enumType) {
//            this.enumType = enumType;
//        }
//
//        public T convert(String source) {
//            if (source.length() == 0) {
//                // It's an empty enum identifier: reset the enum value to null.
//                return null;
//            }
//
//            T[] all = enumType.getEnumConstants();
//            for (T t : all) {
//                if (source.equals(t.codeVal())) return t;
//            }
//
//            for (T t : all) {
//                if (source.equals(t.name())) return t;
//            }
//            return null;
//        }
//    }
//
//}