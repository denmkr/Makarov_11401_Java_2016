package task013;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Denis on 23/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("task013/spring-config-task013.xml");

        Email email = (Email) appContext.getBean("email");
        email.setEmail(".d_en_mara@mail.ru");
    }
}