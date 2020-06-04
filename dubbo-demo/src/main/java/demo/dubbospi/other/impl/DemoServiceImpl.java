package demo.dubbospi.other.impl;

import demo.dubbospi.other.DemoService;
import org.apache.dubbo.common.URL;

import java.util.HashMap;
import java.util.Map;

public class DemoServiceImpl implements DemoService {
    @Override
    public void sayHello() {
        System.out.println("Hello,alias = a1 ,name = " + getClass().getName());
    }

    @Override
    public void adaptiveUse(URL url) {
        System.out.println("Hello,alias = a1 ,name = " + getClass().getName() + ", method adaptiveUse");
        Map map = new HashMap();
        map.put("22", "22");
    }
}