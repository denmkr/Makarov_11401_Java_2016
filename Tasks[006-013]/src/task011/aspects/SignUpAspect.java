package task011.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import ru.models.User;
import ru.repository.UsersRepository;


/**
 * Created by Denis on 23/03/2016.
 */

@Aspect
public class SignUpAspect { // Аспект для проверки наличия логина в базе
    @Around("execution(* *..UsersRepository.signUp(User))") // Прицепляем аспект на метод doGet сервлета LogoutServlet
    public Object checkAuth(ProceedingJoinPoint jp) throws Throwable {
        User user = (User) jp.getArgs()[0]; // Получаем user от сервлета

        /*  Проверяем на отсутствие аналогичного логина в базе  */
        if (!UsersRepository.loginExist(user.getLogin())) {
            return jp.proceed(); // Данного логина не существует, возвращаемся к точке, что бы продолжить выполнение метода
        }

        return false; // Останавливаем, данный логин существует

    }
}