package com.example.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理测试
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/3/27 11:47
 **/
public class ProxyTest2{
    public static void main(String[] args) {
        ProxyStudent ps = new ProxyStudent();
        ProxyStudent proxtps = (ProxyStudent) new ProxyInvo(ps).getProxyObject();
        proxtps.print2();
        System.out.println("-------------------------------------");
        proxtps.print();
    }
}


class ProxyInvo implements MethodInterceptor {
    private final ProxyStudent im;

    ProxyInvo(ProxyStudent im) {
        this.im = im;
    }

    public Object getProxyObject() {
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(im.getClass());
        enhancer.setCallback(this);// 设置回调
        Object result = enhancer.create();//创建并返回代理对象
        return result;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("动态代理，执行前插入");
        Object obj = method.invoke(im, objects);
        System.out.println("动态代理，执行后插入");
        return obj;
    }
}

class ProxyStudent {
    public void print() {
        System.out.println("print 进入打印流程。。。。。");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("print 打印流程结束。。。。。");
    }

    public void print2() {
        System.out.println("print2 2222222222222。。。。。");
    }
}