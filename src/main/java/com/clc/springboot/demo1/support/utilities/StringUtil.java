package com.clc.springboot.demo1.support.utilities;

public class StringUtil {
    public static String getSqlLikeSearch(String search) {
        if (ParamUtil.isNotEmpty(search)) {
            return search.trim().replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_");
        }

        return search;
    }
}

