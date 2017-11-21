package com.elklog.start.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;

@Aspect
public class MethodAroundLoggerAspect {
    private Logger logger = LoggerFactory.getLogger(MethodAroundLoggerAspect.class);

    ThreadLocal<Deque<Long>> traceStack = new ThreadLocal<>();
    ThreadLocal<String> traceIDs = new ThreadLocal<>(); // 没有顺序, 这里没有调用链!!!

    private void push(long mark) {
        Deque deque = traceStack.get() ;
        if(deque == null) {
            deque = new ArrayDeque<>();
            traceStack.set(deque);
        }

        deque.push(mark);
    }

    private Long pop() {
        Deque<Long> deque = traceStack.get() ;
        if(deque == null) {
            deque = new ArrayDeque<>();
            traceStack.set(deque);
        }
        return deque.pop();

    }

    private Long peek() {
        Deque<Long> deque = traceStack.get() ;
        if(deque == null) {
            deque = new ArrayDeque<>();
            traceStack.set(deque);
        }
        return deque.peek();
    }

    private String getTraceID() {

        if(peek() == null) {    // 新的Trace
            traceIDs.set(UUID.randomUUID().toString().replace("-", ""));
        }

        return traceIDs.get();
    }


    @Around("execution(public * com.elklog.start..*.*.*(..))")
    public Object methodAroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MDC.put("traceID", getTraceID());

        push(System.currentTimeMillis());

        logger.info("{}.{}", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName());


        Object result =joinPoint.proceed(joinPoint.getArgs());

        pop();

        return result;
    }

}
