package com.clc.springboot.demo1.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public void A() {
        System.out.println("这是A!");
    }

    public static void printClassInfo(Object object){
        Class c=object.getClass();
        System.out.println("类的名称："+c.getName());

        /**
         * 一个成员方法就是一个method对象
         * getMethod()所有的 public方法，包括父类继承的 public
         * getDeclaredMethods()获取该类所有的方法，包括private ,但不包括继承的方法。
         */
        //获取方法
        Method[] methods=c.getMethods();

        //获取所以的方法，包括private ,c.getDeclaredMethods();

        for(int i=0;i<methods.length;i++){
            //得到方法的返回类型
            Class returnType=methods[i].getReturnType();
            System.out.print(returnType.getName());
            //得到方法名：
            System.out.print(methods[i].getName()+"(");

            Class[] parameterTypes=methods[i].getParameterTypes();
            for(Class class1:parameterTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }
    }

    public static void printFiledInfo(Object o){

        Class c=o.getClass();
        /**
         * getFileds()获取public
         * getDeclaredFields()获取所有
         */
        Field[] fileds=c.getDeclaredFields();

        for(Field f:fileds){
            //获取成员变量的类型
            Class filedType=f.getType();
            System.out.println(filedType.getName()+" "+f.getName());
        }

    }

    public static void printConstructInfo(Object o){
        Class c=o.getClass();

        Constructor[] constructors=c.getDeclaredConstructors();
        for (Constructor con:constructors){
            System.out.print(con.getName()+"(");

            Class[] typeParas=con.getParameterTypes();
            for (Class class1:typeParas){
                System.out.print(class1.getName()+" ,");
            }
            System.out.println(")");
        }
    }


    class A{

        public void add(int a,int b){
            System.out.print(a+b);
        }

        public void toUpper(String a){
            System.out.print(a.toUpperCase());
        }
    }


    public static void main(String[] args) {

        List<?>[] list = new ArrayList<?>[10];
        List<String> list2 = new ArrayList<>();
        List<?> list3 = new ArrayList<>();

//        Class t = Test.class;
//        System.out.println(t.getName());
//        System.out.println();
//
//        Class c1=String.class;
//        Class c2=int.class;
//        Class c3=void.class;
//        System.out.println(c1.getName());
//        System.out.println(c2.getSimpleName());
//        System.out.println(c3.getName());

//        String s="ss";
//        Test.printClassInfo(s);
//        System.out.println("------------------------------------------");
//        Test.printFiledInfo(s);
//        System.out.println("------------------------------------------");
//        Test.printConstructInfo(s);


        Test t = new Test();
        A a = t.new A();
        Class c=a.getClass();
        try {
            Method method=c.getMethod("add",new Class[]{int.class,int.class});
            //也可以 Method method=c.getMethod("add",int.class,int.class);
            //方法的反射操作
            method.invoke(a,10,10);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
