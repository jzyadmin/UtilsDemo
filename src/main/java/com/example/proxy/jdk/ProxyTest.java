package com.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/3/27 11:47
 **/
public class ProxyTest{
    public static void main(String[] args) {
        ProxyStudentImpl ps = new ProxyStudent();
        ProxyStudentImpl impl = (ProxyStudentImpl) Proxy.newProxyInstance(ProxyStudent.class.getClassLoader(), new Class<?>[] { ProxyStudentImpl.class }, new ProxyInvo(ps));
        impl.print2();
        System.out.println("-------------------------------------");
        impl.print();
    }
}


class ProxyInvo implements InvocationHandler {
    private final ProxyStudentImpl im;

    ProxyInvo(ProxyStudentImpl im) {
        this.im = im;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理，执行前插入");
        Object o = method.invoke(im, args);
        System.out.println("动态代理，执行后插入");
        return o;
    }
}


interface ProxyStudentImpl {
    void print();
    void print2();
}
class ProxyStudent implements ProxyStudentImpl{
    @Override
    public void print() {
        System.out.println("print 进入打印流程。。。。。");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("print 打印流程结束。。。。。");
    }

    @Override
    public void print2() {
        System.out.println("print2 2222222222222。。。。。");
    }
}