package demo.dubbo.service;

import demo.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.Service;


/**
 * api
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/3 17:32
 **/
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String helloDubbo(String string) {
        System.out.println("hello dubbo.....");
        return "hello dubbo....." +string;
    }

}
