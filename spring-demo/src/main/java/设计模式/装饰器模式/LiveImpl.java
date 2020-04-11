package 设计模式.装饰器模式;

/**
 * 生活
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 16:41
 **/
public class LiveImpl implements Live {
    @Override
    public void print() {
        System.out.println("2013年出来工作-路恒科技");
    }

    @Override
    public void money() {
        System.out.println("2013年一人吃饱全家不饿，不愁");
    }
}


class Live2014Impl extends AbstractLive{
    public Live2014Impl(Live live) {
        super(live);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("2014年-路恒科技-531工程");
    }

    @Override
    public void money() {
        super.money();
        System.out.println("2014年-有点余额");
    }
}
class Live2015Impl extends AbstractLive{
    public Live2015Impl(Live live) {
        super(live);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("2015年-慕容科技-成都531");
    }

    @Override
    public void money() {
        super.money();
        System.out.println("2015年-报销款很多，成都日子过得还比较潇洒");
    }
}
class Live2016Impl extends AbstractLive{
    public Live2016Impl(Live live) {
        super(live);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("2016年-转角街坊-快销宝系统");
    }

    @Override
    public void money() {
        super.money();
        System.out.println("2016年-长沙买房从此开始负资产");
    }
}
class Live2017Impl extends AbstractLive{
    public Live2017Impl(Live live) {
        super(live);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("2017年-转角街坊-店宝系统");
    }

    @Override
    public void money() {
        super.money();
        System.out.println("2017年-长沙房子还债。。转到信用卡里面了");
    }
}
class Live2018Impl extends AbstractLive{
    public Live2018Impl(Live live) {
        super(live);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("2018年-转角街坊-收银系统");
    }

    @Override
    public void money() {
        super.money();
        System.out.println("2018年-信用卡还钱结束");
    }
}
class Live2019Impl extends AbstractLive{
    public Live2019Impl(Live live) {
        super(live);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("2019年-转角街坊-收银系统（无人便利）");
    }

    @Override
    public void money() {
        super.money();
        System.out.println("2019年-深圳房子购买o(╥﹏╥)o");
    }
}