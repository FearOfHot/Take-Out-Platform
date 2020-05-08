package com.clc.springboot.demo1.support.utilities;

public class StringUtil {
    public static String getSqlLikeSearch(String search) {
        if (ParamUtil.isNotEmpty(search)) {
            return search.trim().replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_");
        }

        return search;
    }

    /**
     * 替换java的日期格式成sql的格式
     *
     * @param javaFormat
     * @return
     */
    public static String transferDateJava2Sql(String javaFormat) {
        if (ParamUtil.isNullOrEmpty(javaFormat)) {
            return javaFormat;
        }
        return javaFormat.replaceAll("(hh|HH):(mi|mm):ss", "%T")
                .replace("MM", "%m")
                .replaceAll("(YYYY|yyyy)", "%Y")
                .replace("dd", "%d");
    }

    /**
     * 判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if (ParamUtil.isNullOrEmpty(str)) {
            return false;
        }
        return str.matches("^[-+]?\\d+$");
    }


    /**
     * 转义单引号和双引号
     *
     * @param str
     * @return
     */
    public static String escapeString(String str, boolean ignore) {
        if (ParamUtil.isNullOrEmpty(str)) {
            return str;
        }
        String specialChar = "";
        if (!ignore) {
            if (str.startsWith("'") && str.endsWith("'")) {
                specialChar = "'";
            } else if (str.startsWith("\"") && str.endsWith("\"")) {
                specialChar = "\"";
            }
            str = str.replaceAll("^(['\"])", "")
                    .replaceAll("(['\"])$", "");
        }

        if (str.contains("'")) {
            str = str.replace("'", "\\\\'");
        }
        if (str.contains("\"")) {
            str = str.replace("\"", "\\\\\"");
        }

        return specialChar + str + specialChar;

    }

    public static String valueOf(Object value) {
        if (null == value) {
            return "";
        }
        return String.valueOf(value);
    }
}

