package com.clc.springboot.demo1.redis.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String guid;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String age;

    @Getter
    @Setter
    private Date createTime;

}
