package spi;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 18:46
 **/

import java.util.ServiceLoader;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 18:46
 **/
public class TestDemo {
    public static void main(String[] args) {
        ServiceLoader<SpiDemo> demo = ServiceLoader.load(SpiDemo.class);
        demo.forEach(SpiDemo::print);
    }
}
