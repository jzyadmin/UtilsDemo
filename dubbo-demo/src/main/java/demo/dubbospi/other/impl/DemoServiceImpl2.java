package demo.dubbospi.other.impl;

import demo.dubbospi.other.DemoService;
import org.apache.dubbo.common.URL;

//@Adaptive
public class DemoServiceImpl2 implements DemoService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = b2 ,name = " + getClass().getName());
    }

    @Override
    public void adaptiveUse(URL url) {
        System.out.println("Hello,alias = b2 ,name = " + getClass().getName() + ", method adaptiveUse");
    }
}