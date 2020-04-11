package 设计模式.委托模式;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 17:26
 **/
public class DemoTest {
    public static void main(String[] args) {
        new LiveBody().print();
    }
}
/**
 * 干活委托人
 */
class LiveBody implements Live{
    Live live = new LiveImpl();
    @Override
    public void print(){
        System.out.println("帮我干活。。。。。。。。");
        live.print();
    }
}


/**
 * 干活的接口
 */
interface Live {
    public void print();
}

/**
 * 干活的实现
 */
class LiveImpl implements Live{
    @Override
    public void print() {
        System.out.println("我要干活。。。。。。。。。。。。。");
    }
}