package com.clc.springboot.classloader;

public class LoadInfo {

    /**
     * 自定义的类加载器
     */
    private MyClassLoader myClassLoader;

    /**
     * 记录要加载的类的时间戳-->加载的时间
     */
    private long loadTime;

    /**
     * 需要被热加载的类
     */
    private BaseManager manager;

    public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }

}
