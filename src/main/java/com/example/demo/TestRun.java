package com.example.demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/10/9 18:56
 **/
public class TestRun {
    public static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        String i1 = null;
        for (int i = 0; i < 10; i++) {
            map.put(i+"", i);
            for (int j = 0; j < 10; j++) {
                new Thread(new TestRunDemo(i+"", j)).start();
            }
        }
    }
}


class TestRunDemo implements Runnable {
    String id;
    int value;

    TestRunDemo(String id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public void run() {
        synchronized (TestRun.map.get(id)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after : 编号{"+id+"},value{"+value+"}");
        }
    }
}