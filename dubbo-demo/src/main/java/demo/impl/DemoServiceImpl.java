package demo.impl;

import demo.DemoService;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"solar"})
public class DemoServiceImpl implements DemoService {

    @Override
    public void sayHello() {
        System.out.println("Hello,alias = a ,name = " + getClass().getName());

    }
}