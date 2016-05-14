package ru.kpfu.dm.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Denis on 23/03/2016.
 */
@Aspect
public class GlobalControllerAspect {

    @Around("execution(* ru.kpfu.dm.controller.GlobalControllerAdvice.getUsername(..))")
    public Object getUser(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return joinPoint.proceed();
    }

}