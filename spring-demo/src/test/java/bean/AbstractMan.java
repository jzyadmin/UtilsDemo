package bean;
/**
 *  基础数据
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/10 15:03
 **/
public class AbstractMan {
    public void init() {
        System.out.println(getClass().getName() + "init.................");
    }

    public void destroy() {
        System.out.println(getClass().getName() + "destroy.................");
    }
}
