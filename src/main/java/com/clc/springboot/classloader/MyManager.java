package com.clc.springboot.classloader;

import java.time.LocalTime;

public class MyManager implements BaseManager {

    @Override
    public void logic() {
        System.out.println(LocalTime.now() + ":类的热加载");
    }

}
