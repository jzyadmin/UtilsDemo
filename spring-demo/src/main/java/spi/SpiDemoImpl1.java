package spi;
/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 18:45
 **/
public class SpiDemoImpl1 implements SpiDemo{

    @Override
    public void print() {
        System.out.println(getClass().getName()+"-------------------------------");
    }
}
