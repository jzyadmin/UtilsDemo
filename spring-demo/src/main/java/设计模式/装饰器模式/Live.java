package 设计模式.装饰器模式;

/**
 * 生活
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 16:41
 **/
public interface Live{
    public void print();
    public void money();
}


abstract class AbstractLive implements Live {
    Live live;

    public AbstractLive(Live live) {
        this.live = live;
    }
    @Override
    public void print(){
        live.print();
    }
    @Override
    public void money(){
        live.money();
    }
}
