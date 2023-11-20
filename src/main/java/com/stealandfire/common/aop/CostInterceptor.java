package com.stealandfire.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CostInterceptor {

    @Around("@annotation(com.stealandfire.common.aop.CostEnable)")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("CostInterceptor interceptor successfully!");
        return joinPoint.proceed();
    }
}
