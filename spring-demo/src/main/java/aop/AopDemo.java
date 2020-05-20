package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/20 8:24
 **/
@Component
@Aspect
public class AopDemo {
    @Around("execution (* aop.CutDemo.*(..))")
    Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("切面前 around。。。。。。。。。。。。。。。");
        try {
            return joinPoint.proceed();
        }finally {
            System.out.println("切面后 around。。。。。。。。。。。。。。。");
        }
    }
    @Before("execution (* aop.CutDemo.*(..))")
    void before(){
        System.out.println("切面前 before。。。。。。。。。。。。。。。");
    }

    @After("execution (* aop.CutDemo.*(..))")
    void after(){
        System.out.println("切面前 after。。。。。。。。。。。。。。。");
    }
}
