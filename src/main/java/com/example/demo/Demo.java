package com.example.demo;

import java.io.Serializable;

/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/16 18:08
 **/
public class Demo implements Serializable {
    private static Demo instance = null;
    Demo() {
        if (instance != null) {
            throw new RuntimeException("只能创建一个对象");
        }
    }

    public static synchronized Demo getInstance() {
        if (instance == null) {
            instance = new Demo();
        }
        return instance;
    }

    private Object readResolve() {
        System.out.println("通过序列化进行对象创建");
        return getInstance();
    }
}
