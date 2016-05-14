package ru.kpfu.dm.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Denis on 23/03/2016.
 */
@Aspect
public class SignUpAspect {

    @Around("execution(* ru.kpfu.dm.controller.SignUpController.signup(..))")
    public Object serviceLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult result = (BindingResult) joinPoint.getArgs()[1];
        if (result.hasErrors()) {
            return "signup";
        }
        return joinPoint.proceed();
    }

}