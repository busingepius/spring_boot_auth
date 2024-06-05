package org.example.lab2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.lab2.exception.Exceptionn;
import org.example.lab2.exception.ExceptionnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Aspect
@Configuration
public class TraceAdvice {

    @Autowired
    LoggerService loggerService;

    @Autowired
    ExceptionnService exceptionnService;

    static String defaultUser = "Collin";

    @Before("execution(* org.example.lab2.service.impl.*.*(..))")
    public void traceBeforeComment(JoinPoint joinPoint) {
        Logger logger = new Logger(LocalDateTime.now(), defaultUser, joinPoint.getSignature().getName());
        loggerService.addLog(logger);
    }

    @Pointcut("@annotation(ExecutionTime)")
    public void trackExecutionTime(){}

    @Around("trackExecutionTime()")
    public Object profile (ProceedingJoinPoint call) throws Throwable{
        StopWatch clock = new StopWatch("");
        clock.start(call.toShortString());
        Object object= call.proceed();
        clock.stop();
        System.out.println(clock.prettyPrint());
        return object;
    }

    @AfterThrowing(pointcut = ("execution(* com.lab2.lab2.service.impl.*.*(..))"), throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        Exceptionn exceptionLog = new Exceptionn(LocalDateTime.now(), defaultUser, joinPoint.getSignature().getName(), ex.getClass().getSimpleName());
        exceptionnService.addException(exceptionLog);
    }



}
