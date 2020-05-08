package com.clc.springboot.demo1.facade.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Message<T> implements Model<T>{

    private int code = 200;
    private T obj;
    private String message;
    private Boolean success;
    private List<Map> errors = new ArrayList<>();

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Message(int code, String message, T obj) {
        this.code = code;
        this.message = message;
        this.setObj(obj);
    }


    public int getCode() {
        return code;
    }

    public Message setCode(int code) {
        this.code = code;
        return this;
    }

    public T getObj() {
        return obj;
    }

    public Message setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isSuccess() {
        this.setSuccess(null == this.success ? this.getCode() == 200 || this.getCode() == 0 : this.success);
        return this.success;
    }


    public List<Map> getErrors() {
        return errors;
    }

    public Message setErrors(List<Map> errors) {
        this.errors = errors;
        return this;
    }

    public Message setErrors(String id, String msg) {
        Map<String, String> field = new HashMap<>(2);
        field.put("id", id);
        field.put("msg", msg);
        this.getErrors().add(field);
        if (this.code == 200 || this.code == 0) {
            this.setCode(590);
        }
        return this;
    }

    public Message setSuccess(Boolean success) {
        this.success = success;
        if (success) {
            if (this.code != 200 && this.code != 0) {
                this.setCode(0);
            }
        } else if (this.code == 200 || this.code == 0) {
            this.setCode(-1);
        }

        return this;
    }

    public Message toMessage() {
        return this;
    }
    public boolean hasObj() {
        return this.obj != null;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", obj=" + obj +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", errors=" + errors +
                '}';
    }
}
