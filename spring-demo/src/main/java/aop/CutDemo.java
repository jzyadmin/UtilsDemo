package aop;

import org.springframework.stereotype.Service;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/20 8:24
 **/
@Service
public class CutDemo {
    public void print() {
        System.out.println(Thread.currentThread().getName()+" 切面测试。。。。。。。");
    }
}
