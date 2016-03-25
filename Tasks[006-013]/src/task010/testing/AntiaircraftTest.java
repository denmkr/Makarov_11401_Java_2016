package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.Aircraft;
import task010.Airport;
import task010.Antiaircraft;
import task010.interfaces.Vehicle;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class AntiaircraftTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void shouldShootCorrect() {
        Antiaircraft antiaircraft = (Antiaircraft) appContext.getBean("antiaircraft");
        Vehicle vehicle = (Aircraft) appContext.getBean("aircraft");
        antiaircraft.shoot(vehicle);

        Assert.assertTrue(true);
    }

    @Test
    public void shouldReloadCorrect() {
        Antiaircraft antiaircraft = (Antiaircraft) appContext.getBean("antiaircraft");
        Vehicle vehicle = (Aircraft) appContext.getBean("aircraft");
        antiaircraft.reload();

        Assert.assertTrue(true);
    }
}
