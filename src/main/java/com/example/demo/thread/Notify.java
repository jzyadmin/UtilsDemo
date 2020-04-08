package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 等待通知
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/1/7 14:35
 **/
public class Notify {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            ThreadTest test = new ThreadTest();
            Thread thread = new Thread(test);
            thread.start();
            String s = test.get();
            System.out.println("args = [" + s + "]");
        }
    }
}

class ThreadTest implements Runnable{
    String value;
    public String get() throws InterruptedException {
        if (value == null) {
            System.out.println(Thread.currentThread().getName() + "get hello word");
            synchronized (this) {
                this.wait();
            }
        }
        System.out.println(Thread.currentThread().getName() + "get hello word");
        return value;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " hello word");
        value = Thread.currentThread().getName();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            notifyAll();
        }
    }
}