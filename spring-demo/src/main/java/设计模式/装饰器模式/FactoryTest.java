package 设计模式.装饰器模式;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 16:41
 **/
public class FactoryTest {
    public static Live FactoryTest(Live live) {
        live = new Live2014Impl(live);
        live = new Live2015Impl(live);
        live = new Live2016Impl(live);
        live = new Live2017Impl(live);
        live = new Live2018Impl(live);
        live = new Live2019Impl(live);
        return live;
    }
}
