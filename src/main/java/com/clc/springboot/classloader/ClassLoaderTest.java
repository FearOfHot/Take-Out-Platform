package com.clc.springboot.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        new Thread(new MsgHandle()).start();
    }

}
