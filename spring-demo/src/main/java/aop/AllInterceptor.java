package aop;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/23 17:01
 **/

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.PreDestroy;

/**
 * 全局拦截器，分线程进行时间调度
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/23 17:01
 **/
@Component
public class AllInterceptor extends DefaultPointcutAdvisor {

    private final ThreadLocal<StopWatch> local = new NamedThreadLocal<>("全局监控");
    public AllInterceptor() {
        setAdvice((MethodInterceptor) invocation -> {
            if (local.get() == null) {
                local.set(new StopWatch());
            }
            StopWatch watch = local.get();
            try {
                watch.start(invocation.getMethod().getDeclaringClass().getName());
                System.out.println("全局代理开启。。。。。。。。。" + invocation.getMethod().getDeclaringClass());

                return invocation.proceed();
            }finally {
                watch.stop();
                System.out.println("全局代理关闭。。。。。。。。。" + watch);
            }
        });
    }

    @PreDestroy
    void destroy() {
        local.remove();
    }
}


