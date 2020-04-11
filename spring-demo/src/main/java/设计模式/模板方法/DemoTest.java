package 设计模式.模板方法;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 17:26
 **/
public class DemoTest {
    public static void main(String[] args) {
        new LiveBody2().print();
        System.out.println("===========================================");
        new LiveBody().print();
    }
}

/**
 * 实际业务
 */
class LiveBody extends AbstractLiveImpl {
    @Override
    public void print(){
        super.print();
        System.out.println("帮我干活。。。。。。。。");
    }
}

/**
 * 实际业务2
 */
class LiveBody2 extends AbstractLiveImpl {
    @Override
    public void before() {
        System.out.println("帮我先准备下工具");
    }
    @Override
    public void after() {
        System.out.println("干完了，请我洗脚");
    }
}
/**
 * 方法接口
 */
interface Live {
    public void before();
    public void print();
    public void after();
}

/**
 * 基础实现类
 */
abstract class AbstractLiveImpl implements Live {
    @Override
    public void print() {
        before();
        System.out.println("我要干活。。。。。。。。。。。。。");
        after();
    }

    @Override
    public void before(){

    }

    @Override
    public void after(){

    }
}