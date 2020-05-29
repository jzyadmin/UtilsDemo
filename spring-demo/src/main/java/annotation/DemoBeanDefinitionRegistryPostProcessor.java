package annotation;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:46
 **/

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 *  BeanDefinitionRegistryPostProcessor demo,自定义标签解析
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:46
 **/
@Component
public class DemoBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.addIncludeFilter(new AnnotationTypeFilter(AnnotationDemo.class));
        scanner.scan("annotation");

        //资源释放,名称是以开头字母小写
        registry.removeBeanDefinition("demoBeanDefinitionRegistryPostProcessor");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }


}
