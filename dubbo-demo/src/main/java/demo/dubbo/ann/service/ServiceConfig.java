package demo.dubbo.ann.service;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.apache.dubbo.common.Constants.DUBBO;

/**
 * 配置
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/6/4 10:50
 **/
@EnableDubbo(scanBasePackages = "demo.dubbo.service")
@Configuration
public class ServiceConfig {
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("anaDemoService");
        return config;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setAddress("zookeeper://192.168.1.11:2181");
        return config;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName(DUBBO);
        config.setPort(20880);
        return config;
    }
}
