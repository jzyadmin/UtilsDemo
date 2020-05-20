package bean.scope;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 启动方法
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/8 8:25
 **/
public class ScopeMain {
    private ApplicationContext context;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext("bean.scope");
    }

    private AtomicInteger num = new AtomicInteger(0);
    @Test
    public void factoryBeanDemoTest() throws InterruptedException {
//        System.out.println(context.getBean(BeanDemo.class));
//        System.out.println(context.getBean(BeanDemo.class));
//        System.out.println(context.getBean(BeanDemo.class));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 6000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(20));
        executor.setRejectedExecutionHandler((r, executor1) -> {
            executor1.setMaximumPoolSize(executor1.getMaximumPoolSize() + 10);
            executor.execute(r);
        });
        executor.setThreadFactory(r -> new Thread(r,"test"));
        for (int i = 0; i < 100; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"--"+num.getAndAdd(1)+"-->"+context.getBean(BeanDemo.class));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---->"+context.getBean(BeanDemo.class));
            });
        }
        Thread.sleep(1001000);
    }
}
