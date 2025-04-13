package main_package.aspect;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Getter
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    private int executionCount = 0;

    @After("execution(* main_package.controller..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Метод завершен: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* main_package.controller..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Вызов метода: " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    @Around("execution( * main_package.controller.*.*( .. ))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        executionCount++;
        Instant timeBeforeExecution = Instant.now();
        Object result = joinPoint.proceed();
        Instant timeAfterExecution = Instant.now();
        Duration duration = Duration.between(timeBeforeExecution, timeAfterExecution);
        log.info("Время выполнения {}: {} ms", joinPoint.getSignature().getName(), duration.toMillis());
        executionCount++;
        return result;
    }
}
