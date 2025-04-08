package main_package.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @After("execution(* main_package.controller..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Метод завершен: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* main_package.controller..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Вызов метода: " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    @Around("execution(* main_package.controller..*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Метод " + joinPoint.getSignature().getName() + " выполнен за " + duration + " мс");
        return result;
    }
}
