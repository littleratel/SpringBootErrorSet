package cn.h2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* cn.h2.controller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }

        long startTime = System.currentTimeMillis();

        Object object = pjp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("time aspect consume " + (endTime - startTime) + " ms");

        System.out.println("time aspect end");

        return object;
    }
}