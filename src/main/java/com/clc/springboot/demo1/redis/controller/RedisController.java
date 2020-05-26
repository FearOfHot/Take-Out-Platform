package com.clc.springboot.demo1.redis.controller;

import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.redis.entity.UserEntity;
import com.clc.springboot.demo1.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@RequestMapping("redis")
@RestController
public class RedisController {

    /**
     * redis中存储的过期时间60s
     */
    private static int ExpireTime = 60;

    @Resource
    private RedisUtil redisUtil;

    @PostMapping("set")
    public boolean redisset(@RequestParam("key") String key, @RequestParam("value") String value){

        UserEntity userEntity =new UserEntity();
        userEntity.setId(Long.valueOf(1));
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("张三");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());

        return redisUtil.set(key,value);
    }

    @RequestMapping("get")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }

    @PostMapping("ok")
    public Message ok() {
        return new Message().setMessage("ok");
    }

}
