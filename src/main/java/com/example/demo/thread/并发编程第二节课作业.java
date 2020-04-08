package com.example.demo.thread;
/**
 * 并发编程第二节课作业
 *
 * 《wait/notify实现生产者和消费者程序》
 * 采用多线程技术，例如wait/notify，设计实现一个符合生产者和消费者问题的程序，对某一个对象（枪膛）进行操作，其最大容量是20颗子弹，生产者线程是一个压入线程，它不断向枪膛中压入子弹，消费者线程是一个射出线程，它不断从枪膛中射出子弹。
 * 请实现上面的程序。
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/10/10 9:04
 **/
public class 并发编程第二节课作业 {
    public static final int maxSize = 20;
    public static volatile int size = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new RunDemo()).start();
        }
    }
    static class RunDemo implements Runnable{

        @Override
        public void run() {
            synchronized (this) {
                while (并发编程第二节课作业.size >= 并发编程第二节课作业.maxSize) {
                    try {
                        System.out.println(Thread.currentThread().getName()+"-当前数量"+并发编程第二节课作业.size);
                        this.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }

            并发编程第二节课作业.size++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-开始执行"+并发编程第二节课作业.size);
            并发编程第二节课作业.size--;
            synchronized (this) {
                this.notifyAll();
            }
        }
    }
}

