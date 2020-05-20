package bean.factorybean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 启动方法
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/8 8:25
 **/
public class FactoryBeanMain {
    private ApplicationContext context;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext("bean");
    }

    @Test
    public void factoryBeanDemoTest() {
        Object object = context.getBean("&factoryBeanDemo");
        System.out.println(object);

        BeanDemo demo = (BeanDemo)context.getBean("factoryBeanDemo");
        System.out.println(demo);

        FactoryBeanDemo factoryBeanDemo = (FactoryBeanDemo)context.getBean("&factoryBeanDemo");
        System.out.println(factoryBeanDemo);

        BeanDemo demo2 = (BeanDemo)context.getBean("factoryBeanDemo");
        System.out.println(demo2);

        FactoryBeanDemo factoryBeanDemo2 = (FactoryBeanDemo)context.getBean("&factoryBeanDemo");
        System.out.println(factoryBeanDemo2);
    }
}
