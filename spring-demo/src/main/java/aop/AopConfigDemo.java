package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/20 8:24
 **/
@Service
@EnableAspectJAutoProxy
public class AopConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop");
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                CutDemo demo = context.getBean(CutDemo.class);
                demo.print();
                demo.print();
            }).start();
        }
    }
}
