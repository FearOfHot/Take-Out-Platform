package com.clc.springboot.demo1.support.property;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

public class PropertyUtil implements ApplicationContextAware {

    private static ApplicationContext atx;

    private static Environment getEnv() {
        return atx.getEnvironment();
    }

    public static String getProperty(String key) {
        return getEnv().getProperty(key);
    }

    public static <T> T getProperty(String key, Class<T> clazz) {
        return getEnv().getProperty(key, clazz);
    }

    public static ApplicationContext getAtx() {
        return atx;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (PropertyUtil.atx == null) {
            PropertyUtil.atx = applicationContext;
        }

    }

    public static <T> T getBean(Class<T> clazz) {
        //        if (canGet("getBean", clazz)) {
        return atx.getBean(clazz);
        //        } else {
        //            throw new ServiceEx(-1, "BeanUtil not allowed to be used in the controller");
        //        }
    }

    public static Object getBean(String beanName) {
        return atx.getBean(beanName);
    }

    private static <T> boolean canGet(String method, Class<T> clazz) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        int i = 0;

        StackTraceElement e;
        for (; i < elements.length; ++i) {
            e = elements[i];
            String className = e.getClassName();
            String methodName = e.getMethodName();
            if ("context.support.utilities.BeanUtil".equals(className) && method.equals(methodName)) {
                break;
            }
        }

        e = elements[i + 1];

        try {
            return isService(e.getClassName());
        } catch (Exception var7) {
            return false;
        }
    }

    private static boolean isService(String className) throws ClassNotFoundException {
        return className == null || !className.contains(".control.") || isService(Class.forName(className).getName());
    }

}
