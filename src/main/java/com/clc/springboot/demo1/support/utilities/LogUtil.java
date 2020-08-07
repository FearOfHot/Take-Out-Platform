package com.clc.springboot.demo1.support.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    public static Logger getLogger() {
        return LogManager.getLogger();
    }

    public static Logger getLogger(Class clazz) {
        return LogManager.getLogger(clazz);
    }

    public static Logger getLogger(Object obj) {
        return LogManager.getLogger(obj);
    }

    public static Logger getLogger(String str) {
        return LogManager.getLogger(str);
    }

    public static void error(Class clazz, Object msg) {
        getLogger(clazz).error(msg);
    }

    public static void error(Object obj, Object msg) {
        getLogger(obj).error(msg);
    }

    public static void error(String str, Object msg) {
        getLogger(str).error(msg);
    }
    public static void error(String format, Object... args) {
        getLogger().error(format,args);
    }
    public static void error(Object obj,String format, Object... args) {
        getLogger(obj).error(format,args);
    }

    public static void error(Object msg) {
        getLogger().error(msg);
    }

}
