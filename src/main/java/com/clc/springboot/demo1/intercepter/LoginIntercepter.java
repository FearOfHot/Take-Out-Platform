package com.clc.springboot.demo1.intercepter;

import com.clc.springboot.demo1.facade.entities.Admin;
import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.enums.exception.ExceptionTypeEnum;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Admin admin = (Admin) session.getAttribute("admin");
        if (ParamUtil.isNullOrEmpty(user) || ParamUtil.isNullOrEmpty(admin)) {
            response.sendError(ExceptionTypeEnum.LOGIN_ERROR.getCode(), ExceptionTypeEnum.LOGIN_ERROR.getMessage());
            System.out.println("未登录！");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
