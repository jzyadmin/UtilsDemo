package 设计模式.工厂模式;

import 设计模式.装饰器模式.*;

/**
 * 工厂模式demo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 18:01
 **/
public class DemoFactory {
    public static void main(String[] args) {

    }
    public static void level() {
        Live live = FactoryTest.FactoryTest(new LiveImpl());
        live.print();
        System.out.println("=============================================================");
        live.money();
    }
    public static void level2() {
        Live live2 = FactoryTest.FactoryTest(new Live() {
            @Override
            public void print() {
                System.out.println("我很快乐哟");
            }

            @Override
            public void money() {
                System.out.println("我和穷哦");
            }
        });
        live2.print();
        System.out.println("=============================================================");
        live2.money();
    }
}