package demo.dubbo.customer;

import demo.dubbo.api.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 客户端调用
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/3 17:34
 **/
public class TestDemoService {
    DemoService demoService;
    @Before
    public void init() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("customer.xml");
        demoService = (DemoService) context.getBean("demoService");
    }
    @Test
    public void helloDubbo() {
        System.out.println(demoService.helloDubbo("sloar"));
    }
}
