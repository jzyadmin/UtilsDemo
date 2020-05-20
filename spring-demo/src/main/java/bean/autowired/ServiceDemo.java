package bean.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Autowired Demo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 14:09
 **/
@Service
public class ServiceDemo {
    @Autowired
    AutowiredDemo demo;

    @PostConstruct
    private void init() {
        System.out.println("ServiceDemo init ...................");
    }
    @PreDestroy
    private void preDestroy() {
        System.out.println("ServiceDemo preDestroy......................");
    }

    public void testMethodPrint() {
        System.out.println("ServiceDemo -> testMethodPrint -> print ................................");
    }
}
