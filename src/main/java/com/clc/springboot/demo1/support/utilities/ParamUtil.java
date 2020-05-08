package com.clc.springboot.demo1.support.utilities;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

public class ParamUtil {
    public static boolean isNullOrEmpty(Object obj) {
        if (null == obj) {
            return true;
        } else if (obj instanceof String) {
            return null == StringUtils.trimToNull((String) obj);
        } else if (obj instanceof StringBuilder) {
            return null == StringUtils.trimToNull(((StringBuilder) obj).toString());
        } else if (obj.getClass().isArray()) {
            return ((Object[]) obj).length == 0;
        } else if (obj instanceof Map) {
            return ((Map) obj).size() == 0;
        } else {
            return obj instanceof Collection && ((Collection) obj).size() == 0;
        }
    }

    public static boolean isNotEmpty(Object obj) {
        return !isNullOrEmpty(obj);
    }
}
