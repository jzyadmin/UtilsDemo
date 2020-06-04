package demo.dubbospi.activate.impl;

import demo.dubbospi.activate.DemoActivateService;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.Adaptive;

@Activate(group = {"young"})
public class DemoActivateServiceImpl3 implements DemoActivateService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = c , 方法上有@Adaptive ,name = " + getClass().getName());
    }
}