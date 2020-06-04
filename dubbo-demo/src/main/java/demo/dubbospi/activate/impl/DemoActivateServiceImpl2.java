package demo.dubbospi.activate.impl;

import demo.dubbospi.activate.DemoActivateService;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"solar" , "young"} , value = "222")
public class DemoActivateServiceImpl2 implements DemoActivateService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = b , 类上有@Activate ,name = " + getClass().getName());
    }
}