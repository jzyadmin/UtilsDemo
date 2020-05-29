package annotation;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:46
 **/

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 *  BeanDefinitionRegistryPostProcessor demo,自定义标签解析
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:46
 **/
@Component
public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AnnotationBeanDemo demo = beanFactory.getBean(AnnotationBeanDemo.class);
        demo.print();
    }
}
