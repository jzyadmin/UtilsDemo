package demo.dubbospi.activate.impl;

import demo.dubbospi.activate.DemoActivateService;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"solar"})
public class DemoActivateServiceImpl implements DemoActivateService {

    @Override
    public void sayHello() {
        System.out.println("Hello,alias = a ,name = " + getClass().getName());

    }
}