package demo.dubbo.ann.customer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/4 10:50
 **/
@EnableDubbo(scanBasePackages = {"demo.dubbo.api","demo.dubbo.ann.customer"})
@ComponentScan(value = {"demo.dubbo.ann.customer"})
@Configuration
public class CustomerConfig {
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("anaDemoCustomer");
        return config;
    }
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setAddress("zookeeper://192.168.1.11:2181");
        return config;
    }
}
