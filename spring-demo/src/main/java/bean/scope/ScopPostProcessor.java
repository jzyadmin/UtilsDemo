package bean.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/30 11:03
 **/
@Component
public class ScopPostProcessor implements BeanFactoryPostProcessor {
    final String scopeDemo = "scopeDemo";
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(scopeDemo, new ScopeDemo());
    }
}
