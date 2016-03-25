package task011.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Denis on 26.03.16.
 */

@Aspect
public class EncodingAspect { // Аспект для изменения кодировки в сервлете

    @Before("execution(* *..LogoutServlet.doGet(*))") // Прицепляем аспект на метод doGet сервлета LogoutServlet
    public void contentEncoding(JoinPoint jp) throws Throwable {
        HttpServletRequest request = (HttpServletRequest) jp.getArgs()[0]; // Получаем request от сервлета
        HttpServletResponse response = (HttpServletResponse) jp.getArgs()[1]; // Получаем response от сервлета

        response.setContentType("text/html;charset=UTF-8"); // Изменяем кодировки
        request.setCharacterEncoding("UTF-8"); // Изменяем кодировки
    }

}
