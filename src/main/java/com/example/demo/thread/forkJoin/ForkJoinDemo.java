package com.example.demo.thread.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/26 18:23
 **/
public class ForkJoinDemo {
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(new ForkJoinTaskDemo());

    }
}
