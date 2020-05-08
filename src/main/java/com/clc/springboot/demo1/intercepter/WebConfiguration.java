package com.clc.springboot.demo1.intercepter;

import com.clc.springboot.demo1.support.listener.SessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        List<String> excludeUrl = new ArrayList<>();
        excludeUrl.add("/admin/login");
        excludeUrl.add("/user/login");
        registry.addInterceptor(new LoginIntercepter()).excludePathPatterns(excludeUrl);
    }

    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new SessionListener());
        return srb;
    }
}
