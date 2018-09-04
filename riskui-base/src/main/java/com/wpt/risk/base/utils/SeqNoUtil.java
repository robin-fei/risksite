package com.wpt.risk.base.utils;

import java.util.Date;

public class SeqNoUtil {

    private static final String FIXED_STRING = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String genFiledName(String prefix, int len) {
        long l = new Date().getTime() % (1 << 20);
        String finalFieldName = prefix + "_" + l;
        if (len < 5)
            len = 5;
        if (len > 10)
            len = 10;
        int fixedLen = FIXED_STRING.length();
        for (int i = 0; i < len; i++) {
            finalFieldName += FIXED_STRING.charAt((int) (fixedLen * Math.random()));
        }
        return finalFieldName;
    }

    public static void main(String[] args) {
        System.out.println(SeqNoUtil.genFiledName("custom", 16));
    }
}