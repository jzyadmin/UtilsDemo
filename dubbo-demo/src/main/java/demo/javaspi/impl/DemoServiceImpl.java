package demo.javaspi.impl;

import demo.javaspi.DemoService;
import org.apache.dubbo.common.extension.Activate;

public class DemoServiceImpl implements DemoService {

    @Override
    public void sayHello() {
        System.out.println("Hello,alias = a ,name = " + getClass().getName());

    }
}