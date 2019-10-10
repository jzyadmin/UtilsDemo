package com.example.demo.thread;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/25 16:50
 **/
public class 按序打印 {
    public void print(String arg) {
        System.out.print(arg);
    }

    public static void main(String[] args) throws InterruptedException {
        new 按序打印();

        Thread.sleep(10000);
    }

    public 按序打印() throws InterruptedException {
        Thread thread = new Thread(this::one);
        Thread thread1 = new Thread(this::two);
        Thread thread2 = new Thread(this::three);

        first(thread);
        second(thread1);
        third(thread2);

    }
    public void one() { print("one"); }
    public void two() { print("two"); }
    public void three() { print("three"); }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
