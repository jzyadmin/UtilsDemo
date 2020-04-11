package namespace;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/10 12:09
 **/
public class JedisMain {
    @Test
    public void ClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springApplicationContext.xml");
        System.out.println("ClassPathXmlApplicationContext 方式启动spring");
        Jedis redis = (Jedis) context.getBean("redis");
        redis.set("hello", "123456");
        System.out.println(redis.get("hello"));
    }
}
