package annotation;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:57
 **/

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:57
 **/
public class AnnotationBeanTest {
    @Test
    public void print() {
        ApplicationContext context = new AnnotationConfigApplicationContext("annotation");
        AnnotationBeanDemo demo = context.getBean(AnnotationBeanDemo.class);
        demo.print();
    }
}
