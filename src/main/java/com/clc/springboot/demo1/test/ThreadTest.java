package com.clc.springboot.demo1.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) {

        // 创建MyCallable对象
        Callable<Integer> myCallable = new MyCallable();
        //使用FutureTask来包装MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                //FutureTask对象作为Thread对象的target创建新的线程
                Thread thread = new Thread(ft);
                //线程进入到就绪状态
                thread.start();
            }
        }

        System.out.println("主线程for循环执行完毕..");

        try {
            //取得新创建的新线程中的call()方法返回的结果
            int sum = ft.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


class MyCallable implements Callable<Integer> {
    private int i = 0;

    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}
