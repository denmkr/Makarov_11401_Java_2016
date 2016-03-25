package task012;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Denis on 23/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("task012/spring-config-task012.xml");

        SomeObject object = (SomeObject) appContext.getBean("object");
        object.execute("Select * from cart union select null,LOAD_FILE('/etc/passwd'),null;");
    }
}