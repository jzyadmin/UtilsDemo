package com.example.utils.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列内对象数据
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/17 9:18
 **/
public class DelayTask implements Delayed {
    public String name;
    public Long delayTime;
    public TimeUnit delayTimeUnit;
    public Long executeTime;//ms

    DelayTask(String name, long delayTime, TimeUnit delayTimeUnit) {
        this.name = name;
        this.delayTime = delayTime;
        this.delayTimeUnit = delayTimeUnit;
        this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long l = this.getDelay(TimeUnit.MILLISECONDS);
        long l1 = o.getDelay(TimeUnit.MILLISECONDS);
        if (l < l1) {
            return -1;
        } else if (l > l1) {
            return 1;
        }
        return 0;
    }
}
