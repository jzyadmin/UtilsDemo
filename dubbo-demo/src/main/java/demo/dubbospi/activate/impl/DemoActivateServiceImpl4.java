package demo.dubbospi.activate.impl;

import demo.dubbospi.activate.DemoActivateService;


public class DemoActivateServiceImpl4 implements DemoActivateService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = d , name = " + getClass().getName());
    }
}