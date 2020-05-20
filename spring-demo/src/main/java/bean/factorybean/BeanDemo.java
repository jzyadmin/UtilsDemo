package bean.factorybean;

/**
 * beandemo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/30 10:15
 **/
public class BeanDemo {
    private String value = "2";
    public BeanDemo() {

    }

    public void print() {
        System.out.println("BeanDemo print ......................." + value);
    }
}
