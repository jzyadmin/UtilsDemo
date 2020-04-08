package com.example.demo.thread;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/12/28 14:41
 **/

import java.util.concurrent.Semaphore;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/12/28 14:41
 **/
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        SemaphoreDemo demo = new SemaphoreDemo();

        for (int i = 0; i < 1000; i++) {
            new Thread(new RunDemo(i, demo)).start();
        }
        Thread.sleep(100000);

    }
    static class RunDemo implements Runnable{
        private int i;
        private SemaphoreDemo demo;
        public RunDemo(int i, SemaphoreDemo demo) {
            this.i = i;
            this.demo = demo;
        }

        @Override
        public void run() {
            demo.putItem(i);
        }
    }

    private static final int MAX_AVAILABLE = 3;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x))
            available.release();
    }

    // Not a particularly efficient data structure; just for demo

    protected Object[] items = new Object[MAX_AVAILABLE];
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    System.out.println("markAsUnused used true = [" + i + "]");
                    used[i] = false;
                    return true;
                } else{
                    System.out.println("markAsUnused used false = [" + i + "]");
                    return false;
                }
            }
        }
        return false;
    }
}
