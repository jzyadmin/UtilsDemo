package bean.autowired;

import bean.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Autowired Demo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 14:09
 **/
@Component
public class AutowiredDemo{
    @Autowired
    ServiceDemo serviceDemo;

    @PostConstruct
    public void init() {
        System.out.println("AutowiredDemo init ...................");
        serviceDemo.testMethodPrint();
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("AutowiredDemo preDestroy......................");
    }
}
