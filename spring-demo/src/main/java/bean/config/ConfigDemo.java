package bean.config;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 15:55
 **/

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 15:55
 **/
@Configuration
@ComponentScan("bean")
public class ConfigDemo {
    public static void main(String[] args) {
        System.out.println("starting -----------------------------启动中");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigDemo.class);
        System.out.println("startd -----------------------------启动结束");
    }
}
