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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (PropertyUtil.atx == null) {
            PropertyUtil.atx = applicationContext;
        }

    }

    public static <T> T getBean(Class<T> clazz) {
        return atx.getBean(clazz);
    }

    public static Object getBean(String beanName) {
        return atx.getBean(beanName);
    }

    private static boolean isService(String className) throws ClassNotFoundException {
        return className == null || !className.contains(".control.") || isService(Class.forName(className).getName());
    }

}
