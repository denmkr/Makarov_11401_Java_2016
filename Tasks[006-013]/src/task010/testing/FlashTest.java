package task010.testing;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.Aircraft;
import task010.Antiaircraft;
import task010.Flash;
import task010.interfaces.Human;
import task010.interfaces.Vehicle;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class FlashTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void shouldReleaseCorrect() {
        Flash flash = (Flash) appContext.getBean("flash");
        ArrayList<Human> humans = (ArrayList<Human>) appContext.getBean("humans");
        flash.releaseTo(humans);
    }

}
