package demo.impl;

import demo.DemoService;
import org.apache.dubbo.common.extension.Adaptive;


public class DemoServiceImpl4 implements DemoService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = d , name = " + getClass().getName());
    }
}