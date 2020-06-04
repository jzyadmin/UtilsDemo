package demo.javaspi.impl;

import demo.javaspi.DemoService;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.Adaptive;

public class DemoServiceImpl3 implements DemoService {
    @Override
    @Adaptive
    public void sayHello() {
        System.out.println("Hello,alias = c , 方法上有@Adaptive ,name = " + getClass().getName());
    }
}