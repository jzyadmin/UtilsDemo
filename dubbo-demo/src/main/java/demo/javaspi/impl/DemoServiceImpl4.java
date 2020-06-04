package demo.javaspi.impl;

import demo.javaspi.DemoService;


public class DemoServiceImpl4 implements DemoService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = d , name = " + getClass().getName());
    }
}