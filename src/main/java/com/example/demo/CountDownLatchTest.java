package com.example.demo;

import com.example.utils.SerializeUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 单例模式，发令枪测试单例创建
 * 1、修改发令枪数量
 * 2、修改doWork 方法内容即可使用
 * @author 孟星魂, mengxinghun@jfun365.cn
 * @create 2019/9/16 18:11
 **/
public class CountDownLatchTest {

    // TODO 发令枪数量设置
    private static final int N = 10;

    public static void main(String rgs[]) throws InterruptedException {
        //发令枪测试
        CountDownLatch doneSignal = new CountDownLatch(N);

        Executor service = Executors.newCachedThreadPool();
        for (int i = 0; i < N; ++i) // create and start threads
            service.execute(new WorkerRunnable(doneSignal, i));

        doneSignal.await();           // wait for all to finish


    }
}


class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;
    WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doneSignal.countDown();
        doWork(i);
    }

    // TODO 其他业务测试在此方法内修改代码即可
    void doWork(int i) {
        System.out.println(i + "正常获取--->"+ Demo.getInstance());
        System.out.println(i + "序列化对象--->"+ SerializeUtil.unserialize(SerializeUtil.serialize(Demo.getInstance())));
        try {
            System.out.println(i + "反射创建对象--->" + Demo.class.newInstance());
        } catch (Exception e) {
            System.out.println(i + "反射创建对象--->"+ e.getMessage());
        }

    }
}