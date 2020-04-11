package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * lookupdemo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/10 15:25
 **/
@Component
public class LookUpBase {
    public void printLog() {
        System.out.println(LookUpBase.class.getName() +" print log...............");
    }
}
