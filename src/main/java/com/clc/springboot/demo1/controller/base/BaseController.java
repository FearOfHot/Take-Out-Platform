package com.clc.springboot.demo1.controller.base;

import com.clc.springboot.demo1.facade.entities.Admin;
import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.support.property.PropertyUtil;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class BaseController {

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    protected HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }

    protected HttpSession getSession() {
        return this.getRequest().getSession();
    }

    public Object getAttribute(String key) {
        Object obj = this.getRequest().getAttribute(key);
        return null == obj ? this.getSession().getAttribute(key) : obj;
    }

    public void removeAttribute(String key) {
        this.getRequest().removeAttribute(key);
        this.getSession().removeAttribute(key);
    }

    protected String getParam(String name) {
        return this.getRequest().getParameter(name);
    }

    public String[] getParams(String name) {
        return this.getRequest().getParameterValues(name);
    }


//    protected Long currentUserId() {
//        User user = this.currentUser();
//        return ParamUtil.isNotEmpty(user) ? user.getId() : null;
//    }
//
//    protected Long currentAdminId() {
//        Admin admin = this.currentAdmin();
//        return ParamUtil.isNotEmpty(admin) ? admin.getId() : null;
//    }
//
//    protected User currentUser() {
//        return PropertyUtil.getBean(User.class);
//    }
//
//    protected Admin currentAdmin() {
//        return PropertyUtil.getBean(Admin.class);
//    }

}
