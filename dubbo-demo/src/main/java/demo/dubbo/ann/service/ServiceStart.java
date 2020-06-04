package demo.dubbo.ann.service;/**
 * 启动服务端
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/3 17:45
 **/

import demo.dubbo.ann.service.ServiceConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * 启动服务端
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/3 17:45
 **/
public class ServiceStart {
    @Test
    public void start () throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        System.out.println(getClass().getCanonicalName() + "start is success");
        System.in.read(); // 按任意键退出
    }
}
