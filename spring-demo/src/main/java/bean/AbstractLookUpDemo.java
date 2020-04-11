package bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * lookupdemo
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/10 15:25
 **/
@Component
public abstract class AbstractLookUpDemo {
    public void showPrint() {
        getLookUpBase().printLog();
    }
    @Lookup(value = "lookUpBase")
    public abstract LookUpBase getLookUpBase();
}
