package com.clc.springboot.demo1.support.utilities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Objects;

public class FormatUtil {

    /**
     * 数字格式化
     *
     * @param value
     * @param format
     * @return 格式化失败返回原value
     */
    public static Object formatNumber(Object value, String format) {
        try {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));
            String result = getDecimalFormat(format).format(bigDecimal);
            return result.startsWith(format) ? value : result;
        } catch (NumberFormatException e) {
            LogUtil.error("{}不是数字格式\n{}", value, e.getMessage());
            return value;
        } catch (IllegalArgumentException e) {
            LogUtil.error("{}格式转换异常\n{}", value, e.getMessage());
            return value;
        }
    }

    private static DecimalFormat getDecimalFormat(String format) {
        return new DecimalFormat(format);
    }

    public static String formatMessage(String message, Object... format) {
        String result = message;
        if (Objects.nonNull(format)) {
            result = MessageFormat.format(message, format);
        }
        return result.replaceAll("\\{\\s*\\d+\\s*}", "").replaceAll(",$", "");
    }

}
