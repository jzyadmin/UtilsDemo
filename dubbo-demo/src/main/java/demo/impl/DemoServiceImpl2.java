package demo.impl;

import demo.DemoService;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"solar" , "young"} , value = "test")
public class DemoServiceImpl2 implements DemoService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = b , 类上有@Activate ,name = " + getClass().getName());
    }
}