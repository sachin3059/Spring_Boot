package com.example.FakeCommerce.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackTimeAspect {

    @Around("@annotation(trackTime)")
    public Object measure(ProceedingJoinPoint joinPoint, TrackTime trackTime) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            long time = System.currentTimeMillis() - start;
            System.out.println("Method: " + joinPoint.getSignature() + " took " + time + " ms" + trackTime.value());
        }
    }
}
