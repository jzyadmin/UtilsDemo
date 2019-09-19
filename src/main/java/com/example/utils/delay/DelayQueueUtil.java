package com.example.utils.delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/17 9:32
 **/
public class DelayQueueUtil {
    private DelayQueue<DelayTask> delayTasks = null;
    DelayQueueUtil() {
        getInstance();
    }

    private synchronized DelayQueue<DelayTask> getInstance() {
        if (delayTasks == null) {
            delayTasks = new DelayQueue<>();
        }
        return delayTasks;
    }


    public static void main(String[] args) {
        DelayQueue<DelayTask> delayQueues = new DelayQueue<>();
        delayQueues.add(new DelayTask("1", 1000L, TimeUnit.MILLISECONDS));
        delayQueues.add(new DelayTask("2", 2000L, TimeUnit.MILLISECONDS));
        delayQueues.add(new DelayTask("3", 3000L, TimeUnit.MILLISECONDS));
        System.out.println("queue put done");

        while(!delayQueues.isEmpty()) {
            try {
                DelayTask task = delayQueues.take();

                System.out.println(task.name + ":" + System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
