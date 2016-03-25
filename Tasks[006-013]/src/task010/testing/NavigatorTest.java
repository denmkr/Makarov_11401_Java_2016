package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.Age;
import task010.Navigator;
import task010.Place;
import task010.interfaces.Human;
import task010.interfaces.Vehicle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class NavigatorTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void shouldSitDownIntoVehicleCorrect() {
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        Vehicle vehicle = (Vehicle) appContext.getBean("aircraft");

        Assert.assertTrue(navigator.sitDownInto(vehicle));
    }

    @Test
    public void shouldGoOutFromVehicleCorrect() {
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        Vehicle vehicle = (Vehicle) appContext.getBean("aircraft");

        Assert.assertTrue(navigator.goOutFrom(vehicle));
    }


    @Test
    public void shouldGoToCorrect() {
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        Place place = (Place) appContext.getBean("place");
        navigator.goTo(place);

        Assert.assertEquals(navigator.getPlace(), place);
    }

    @Test
    public void shouldSayToCorrect() {
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        navigator.sayTo((Human) appContext.getBean("pilot"));

        Assert.assertTrue(true);
    }

    @Test
    public void shouldSetAgeCorrect() {
        Navigator navigator = (Navigator) appContext.getBean("navigatorWithAge");

        Assert.assertTrue(navigator.getAge().getDay() == 10 && navigator.getAge().getMonth() == 2 && navigator.getAge().getYear() == 1);
    }

    @Test
    public void shouldIsBlindedCorrect() {
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        navigator.setBlinded(true);

        Assert.assertTrue(navigator.isBlinded());
    }
}
