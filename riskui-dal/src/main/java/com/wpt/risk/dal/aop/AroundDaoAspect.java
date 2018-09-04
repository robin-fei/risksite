package com.wpt.risk.dal.aop;

import com.wpt.risk.base.exception.RiskException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
@Aspect
public class AroundDaoAspect {
    private final static Logger logger = LoggerFactory.getLogger(AroundDaoAspect.class);

    @Around("execution(* com.wpt.risk.*dal.*.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (RiskException e) {
            throw e;
        } catch (Exception e) {
            logger.error("failed@AroundDaoAspect.around", e);
            throw e;
        }

    }
}
