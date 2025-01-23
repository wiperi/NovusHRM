package com.wiperi.novuscrm.aop;

import com.wiperi.novuscrm.mapper.LogMapper;
import com.wiperi.novuscrm.pojo.OperateLog;
import com.wiperi.novuscrm.util.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private ResourceLoader resourceLoader;

    // Pointcut method (common pointcut expression)
    @Pointcut("execution(* com.wiperi.novuscrm.service.impl.EmpServiceImpl.*(..))")
    private void allService() {
    }

    // Around advice
    @Around("@annotation(com.wiperi.novuscrm.anno.LogOperation)")
    public Object logElapsedTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("Method: {}, Time: {}ms", proceedingJoinPoint.getSignature(), end - start);

        OperateLog operateLog = new OperateLog(
                null,
                UserContext.getUserId(),
                LocalDateTime.now(),
                proceedingJoinPoint.getTarget().getClass().getName(),
                proceedingJoinPoint.getSignature().getName(),
                Arrays.toString(proceedingJoinPoint.getArgs()),
                null,
                end - start);

        if (result != null) {
            operateLog.setReturnValue(result.toString());
        }

        logMapper.insertLog(operateLog);

        return result;
    }

    // Before advice (referencing the pointcut)
    @Before("allService()")
    public void before(JoinPoint joinPoint) {
        // log.info("before ...");
    }

    // After advice
    @After("allService()")
    public void after(JoinPoint joinPoint) {
        // log.info("after ...");
    }

    // After returning advice (executed if the program runs normally)
    @AfterReturning("allService()")
    public void afterReturning(JoinPoint joinPoint) {
        // log.info("afterReturning ...");
    }

    // After throwing advice (executed if an exception occurs)
    @AfterThrowing("allService()")
    public void afterThrowing(JoinPoint joinPoint) {
        // log.info("afterThrowing ...");
    }
}
