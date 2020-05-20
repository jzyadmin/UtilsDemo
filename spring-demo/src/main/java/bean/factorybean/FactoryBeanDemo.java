package bean.factorybean;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/30 10:13
 **/

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/30 10:13
 **/
@Component
@Scope(SCOPE_PROTOTYPE)
public class FactoryBeanDemo implements FactoryBean {
    private ThreadLocal<Object> local = new ThreadLocal<>();
    @Override
    public Object getObject() throws Exception {
        if (local.get() == null) {
            local.set(new BeanDemo());
        }
        return local.get();
    }

    @Override
    public Class<?> getObjectType() {
        return BeanDemo.class;
    }
}
