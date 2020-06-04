package demo.dubbo.ann.customer;

import demo.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 客户端调用
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/3 17:34
 **/
@Component
public class TestDemoService {
    @Reference
    DemoService demoService;

    public void helloDubbo() {
        System.out.println(demoService.helloDubbo("sloar"));
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);
        System.out.println(TestDemoService.class.getName() + "start is success");
        TestDemoService service = context.getBean(TestDemoService.class);
        service.helloDubbo();
    }
}
