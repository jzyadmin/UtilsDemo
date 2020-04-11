package namespace;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

class TestBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Jedis.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        JedisShardInfo info = new JedisShardInfo(element.getAttribute("host"));
        info.setPassword(element.getAttribute("password"));
        builder.addConstructorArgValue(info);
//        super.doParse(element, builder);
    }
}