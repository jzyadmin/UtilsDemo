package com.example.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 引用测试demo
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/25 9:26
 **/
public class DemoReference {
    public static void main(String[] args) {
        softReference();
        WeakReference();

    }

    public static void softReference() {
        Object obj = new Byte((byte) (1024*1024*5));
        SoftReference<Object> sf = new SoftReference<>(obj);
        System.out.println("softReference isEnqueued:" + sf.isEnqueued());
        System.out.println("重置之前：" + obj);
        obj = null;
        //有时候会返回null
        System.out.println("softReference isEnqueued:" + sf.isEnqueued());

        Map<String, String> map = new HashMap<>();
        map.put("222", "2");

    }

    public static void WeakReference() {
        Object obj = new Object();
        WeakReference<Object> wf = new WeakReference<>(obj);
        obj = null;
        //有时候会返回null
        //返回是否被垃圾回收器标记为即将回收的垃圾
        System.out.println("WeakReference isEnqueued:" + wf.isEnqueued());
    }

    public static void PhantomReference() {
        Object obj = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> pf = new PhantomReference<>(obj , queue);
        obj = null;
        //永远返回null
        pf.get();
        //返回是否从内存中已经删除
        pf.isEnqueued();
    }
}
