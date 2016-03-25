package task012.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 23/03/2016.
 */
@Aspect
public class CheckQueryAspect {
    @Around("execution(* *..SomeObject.execute(String))")
    public Object checkQuery(ProceedingJoinPoint jp) throws Throwable {
        String query = (String) jp.getArgs()[0];
        query = query.toLowerCase();

        Pattern pattern = Pattern.compile("^((.*)(select)(.*)(union select)(.*)|(.*)(load_file|null|benchmark|(like '\".addslashes($password).\"'))(.*)|(.*)(--))$");
        Matcher matcher = pattern.matcher(query);

        if (matcher.matches()) {
            System.out.println("sql injection is founded");
            return null;
        }

        return jp.proceed();

    }
}