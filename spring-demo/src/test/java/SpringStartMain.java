/**
 * 启动方法
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/8 8:45
 **/

import bean.Man;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 启动方法
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/8 8:45
 **/
public class SpringStartMain {

    @Test
    public void ClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springApplicationContext.xml");
        System.out.println("ClassPathXmlApplicationContext 方式启动spring");
        run(context);
    }

    @Test
    public void   AnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("bean");
        System.out.println("AnnotationConfigApplicationContext 方式启动spring");
        run(context);
    }
    @Test
    public void   FileSystemXmlApplicationContext() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("E:\\testadm\\UtilsDemo\\spring-demo\\src\\main\\resources\\springApplicationContext.xml");
        System.out.println("AnnotationConfigApplicationContext 方式启动spring");
        run(context);
    }


    public void run(ApplicationContext context) {
        Man man = context.getBean(Man.class);
        man.setName("2222");
        System.out.println("args = [" + man.getName() + "]");
    }
}
