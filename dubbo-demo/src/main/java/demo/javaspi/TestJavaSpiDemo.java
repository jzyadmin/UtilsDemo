package demo.javaspi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/21 22:07
 **/
public class TestJavaSpiDemo {
    @Test
    public void test() {
        ServiceLoader<DemoService> demoServices = ServiceLoader.load(DemoService.class);
        demoServices.forEach(d -> d.sayHello());
    }
}
