package com.example.demo.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/10/15 16:22
 **/
public class ThreadTimeOut {
    int poolSize;
    Long timeOut;
    AtomicInteger size = new AtomicInteger(5);
    Thread[] threads;
    public ThreadTimeOut(int poolSize, Long timeOut) {
        this.poolSize = poolSize;
        this.timeOut = timeOut;
        this.threads = new Thread[poolSize];
//        System.out.println(threads.length);
        new ScheduledThreadPoolExecutor(1);

    }

    private void getlock() {
        if (size.get() == poolSize) {
            synchronized (this) {
                try {
                    wait(timeOut);
                    if (size.get() != poolSize) {
                        size.decrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void execute(Runnable thread) {
        getlock();
        System.out.println("thread begin = [" + Thread.currentThread().getName() + "]");
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(thread);
            threads[i].start();
        }
        System.out.println("thread end = [" + Thread.currentThread().getName() + "]");

        notifyAll();

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());

//        ThreadTimeOut t = new ThreadTimeOut(5, (long) 60);
//        for (int i = 0; i < 100; i++) {
//            t.execute(() -> {
//                System.out.println("睡觉奥");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("睡醒了---");
//            });
//        }
//        Thread.sleep(1000000);
    }
}
