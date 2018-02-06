package com.le.www.makejarandaar;

/**
 * Created by wangweijun on 2018/2/6.
 */

public class Singleton {

    static class SingletonHolder {
        private final static Singleton singleton = new Singleton();
    }


    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

}
