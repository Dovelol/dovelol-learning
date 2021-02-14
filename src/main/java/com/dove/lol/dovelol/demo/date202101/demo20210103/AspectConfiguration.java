package com.dove.lol.dovelol.demo.date202101.demo20210103;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Dovelol
 * @date 2021/1/3 16:47
 */
@Aspect
public class AspectConfiguration {

    public AspectConfiguration() {
        System.out.println("AspectConfiguration constructor");
    }


    @Pointcut("execution(public * *(..))")
    private void anyPublicMethod(){
        System.out.println("@Pointcut at any public method.");
    }

    @Before("anyPublicMethod()")
    public void beforeAnyPublicMethod(){
        System.out.println("Before any public method.");
    }

    @Around("anyPublicMethod()")
    public Object aroundAnyPublicMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around any public method.");
        return joinPoint.proceed();
    }

}
