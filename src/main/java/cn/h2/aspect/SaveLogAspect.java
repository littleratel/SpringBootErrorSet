package cn.h2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SaveLogAspect {

    @Pointcut("@annotation(annotation.SaveLog)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;

        saveLog(point, time);

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        //
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //请求的类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();

        //请求的参数
        Object[] args = joinPoint.getArgs();

        //=============================================
        //
        // Here are some operations to save logs
        //
        //=============================================

        System.out.println("=====> SysLogAspect save log successfully!");
    }
}
