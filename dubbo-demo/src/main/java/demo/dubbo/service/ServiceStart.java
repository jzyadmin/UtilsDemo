package demo.dubbo.service;/**
 * 启动服务端
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/3 17:45
 **/

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 启动服务端
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/3 17:45
 **/
public class ServiceStart {
    @Test
    public void start () throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
        System.in.read(); // 按任意键退出
    }
}
