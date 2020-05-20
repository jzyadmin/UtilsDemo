package bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * beandemo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/30 10:15
 **/
@Component
@Scope("scopeDemo")
public class BeanDemo {
    private String value = "2";
    public BeanDemo() {

    }

    public void print() {
        System.out.println("BeanDemo print ......................." + value);
    }
}
