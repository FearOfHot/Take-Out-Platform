package com.clc.springboot.demo1.support.excepts;

import com.clc.springboot.demo1.facade.enums.exception.ExceptionTypeEnum;
import com.clc.springboot.demo1.support.utilities.FormatUtil;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceEx extends RuntimeException {

    private int code = -1;
    private Map<String, Object> obj = new HashMap<>();
    private List<String> msgList;

    public ServiceEx() {
    }

    public ServiceEx(int code) {
        this.code = code == 0 ? -1 : code;
    }

    public ServiceEx(int code, String message) {
        super(message);
        this.code = code == 0 ? -1 : code;
    }

    public ServiceEx(ExceptionTypeEnum exceptionEnum) {
        super(FormatUtil.formatMessage(exceptionEnum.getMessage()));
        this.code = exceptionEnum.getCode() == 0 ? -1 : exceptionEnum.getCode();
    }

    public ServiceEx(ExceptionTypeEnum exceptionEnum, List<String> msgList) {
        super(FormatUtil.formatMessage(exceptionEnum.getMessage()));
        this.setMsgList(msgList);
        this.code = exceptionEnum.getCode() == 0 ? -1 : exceptionEnum.getCode();
    }

    public ServiceEx(ExceptionTypeEnum exceptionEnum, Object... objects) {
        super(FormatUtil.formatMessage(exceptionEnum.getMessage(), objects));
        this.code = exceptionEnum.getCode() == 0 ? -1 : exceptionEnum.getCode();
    }

    public ServiceEx(ExceptionTypeEnum exceptionEnum, Throwable cause) {
        super(FormatUtil.formatMessage(exceptionEnum.getMessage(), (null == cause || null == cause.getMessage()) ? "" : cause.getMessage()), cause);
        this.code = exceptionEnum.getCode() == 0 ? -1 : exceptionEnum.getCode();
    }

    public ServiceEx(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code == 0 ? -1 : code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code == 0 ? -1 : code;
    }

    public Object getObj(String key) {
        return this.obj.get(key);
    }

    public ServiceEx setObj(String key, Object obj) {
        this.obj.put(key, obj);
        return this;
    }

    public List<String> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<String> msgList) {
        this.msgList = msgList;
    }

    @Override
    public String getMessage() {
        if (StringUtils.isNotEmpty(super.getMessage())) {
            return super.getMessage();
        }
        if (ParamUtil.isNotEmpty(super.getCause())) {
            return super.getCause().getMessage();
        }
        return "";
    }

}
