import bean.Man;
import bean.autowired.AutowiredDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 启动方法
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/8 8:25
 **/
public class SpringStartMain {

    public static void main(String[] args) {
        ApplicationContext context = AnnotationConfigApplicationContext();
        AutowiredDemo man = (AutowiredDemo) context.getBean("autowiredDemo");

//        System.out.println("args = [" + man.getName() + "]");
    }

    public static ApplicationContext ClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springApplicationContext.xml");
        return context;
    }

    public static ApplicationContext AnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop" , "bean");
        return context;
    }
}
