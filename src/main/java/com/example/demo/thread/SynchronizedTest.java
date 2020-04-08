package com.example.demo.thread;
public class SynchronizedTest {
    public static String string = "222222222222";
    public static synchronized void  test() {
        string = string + "1";
        System.out.println(Thread.currentThread().getName() + string);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> SynchronizedTest.test());
        }


        int t = 1;
        int a = 2;
        int b = 3;
        int c = 4;
        int d = 5;
        int e = 6;

        System.out.println("args = [" + (a&t) + "]");
        System.out.println("args = [" + (a << 2)+"," + ((a>>t)&t) + "]");
        System.out.println("args = [" + (c&t) + "]");
        System.out.println("args = [" + (d&t) + "]");
        System.out.println("args = [" + (e&t) + "]");
    }
}


