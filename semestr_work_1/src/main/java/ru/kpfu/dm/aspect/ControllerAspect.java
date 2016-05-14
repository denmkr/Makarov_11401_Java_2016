package ru.kpfu.dm.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * Created by Denis on 23/03/2016.
 */
@Aspect
public class ControllerAspect {
    private static Logger log = Logger.getLogger(ServiceAspect.class);

    @After("execution(* ru.kpfu.dm.controller.*Controller.*(..))")
    public void serviceLogging(JoinPoint joinPoint) {
        log.info(new Date()
                + " Page "
                + joinPoint.getSignature().getName()
                + " is loaded" + "\n");
    }

}