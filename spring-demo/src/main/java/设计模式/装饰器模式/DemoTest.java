package 设计模式.装饰器模式;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 16:41
 **/
public class DemoTest {
    public static void main(String[] args) {
        Live live = new LiveImpl();
        live = new Live2014Impl(live);
        live = new Live2015Impl(live);
        live = new Live2016Impl(live);
        live = new Live2017Impl(live);
        live = new Live2018Impl(live);
        live = new Live2019Impl(live);
        live.print();
        System.out.println("=============================================================");
        live.money();
    }
}
