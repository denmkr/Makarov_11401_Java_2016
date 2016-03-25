package task013.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 23/03/2016.
 */
@Aspect
public class CheckEmailAspect {
    @Around("execution(* *..Email.setEmail(String))")
    public Object checkEmail(ProceedingJoinPoint jp) throws Throwable {
        String email = (String) jp.getArgs()[0];
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{1}[a-zA-Z0-9._-]{1,}@[a-zA-Z]{1,}.[a-z]{2,5}$");

        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return jp.proceed();
        }

        System.out.println("Sorry, your email is incorrect");
        return null;

    }
}