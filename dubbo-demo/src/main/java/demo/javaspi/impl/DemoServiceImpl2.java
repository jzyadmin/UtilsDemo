package demo.javaspi.impl;

import demo.javaspi.DemoService;
import org.apache.dubbo.common.extension.Activate;

public class DemoServiceImpl2 implements DemoService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = b , 类上有@Activate ,name = " + getClass().getName());
    }
}