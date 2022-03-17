package com.demo.util;


public class StringUtils {
    /**
     * 字符串非空判断（"",null,"null"）
     *
     * @param o
     * @return
     */
    public static boolean isBlank(Object o) {
        if (null == o || o.toString().trim().length() == 0
                || "null".equalsIgnoreCase(o.toString())) {
            return true;
        } else {
            return false;
        }
    }

}
