package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.*;
import task010.interfaces.Human;
import task010.interfaces.Vehicle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AmphibianTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void amphibianShouldBeEmpty() {
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");

        Assert.assertTrue(amphibian.getPilot() == null && amphibian.getNavigator() == null);
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Amphibian amphibian = (Amphibian) appContext.getBean("fullAmphibian");

        Assert.assertFalse(amphibian.getDrivers().isEmpty());
    }

    @Test
    public void amphibianShouldStartCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");
        amphibian.start();

        Assert.assertTrue(amphibian.isStarted());
    }

    @Test
    public void amphibianShouldStopCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");
        amphibian.start();
        amphibian.stop();

        Assert.assertFalse(amphibian.isStarted());
    }

    @Test
    public void amphibianShouldChangeSpeed() {
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibianWithSpeed300");

        Assert.assertEquals(amphibian.getSpeed(), 300, 1e-9);
    }

    @Test
    public void amphibianShouldChangePosition() {
        Place place = (Place) appContext.getBean("place");
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibianWithPlace");

        Assert.assertEquals(amphibian.getPlace(), place);
    }

    @Test
    public void amphibianShouldDestroyCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("fullAmphibianWithSpeed");
        amphibian.destroy();

        Assert.assertTrue(amphibian.getSpeed() == 0 && amphibian.getPilot() == null && amphibian.getNavigator() == null && !amphibian.isStarted());
    }

    @Test
    public void amphibianShouldAddDriversCorrect() {
        Pilot pilot = (Pilot) appContext.getBean("pilot");
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");
        amphibian.addDrivers(pilot, navigator);

        Assert.assertFalse(amphibian.getDrivers().isEmpty());
    }

    @Test
    public void amphibianShouldGetDriversCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("fullAmphibian");

        Assert.assertFalse(amphibian.getDrivers().isEmpty());
    }

    @Test
    public void amphibianShouldRemoveDriversCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("fullAmphibian");
        amphibian.removeDrivers();

        Assert.assertTrue(amphibian.getPilot() == null && amphibian.getNavigator() == null);
    }

    @Test
    public void amphibianShouldAddDriverCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("fullAmphibian");

        Pilot pilot = (Pilot) appContext.getBean("pilot");
        amphibian.setPilot(null);
        amphibian.addDriver(pilot);

        Assert.assertEquals(amphibian.getDrivers().get(0), pilot);
    }


    @Test
    public void amphibianShouldAddPassengerCorrect() {
        Human passenger = (Human) appContext.getBean("passenger");

        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");
        amphibian.addPassenger(passenger);

        Assert.assertEquals(amphibian.getPassengersCount(), 1);
    }

    @Test
    public void amphibianShouldPlungeCorrect() {
        Place place = (Place) appContext.getBean("place");
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");
        amphibian.plunge(place);

        Assert.assertTrue(amphibian.getPlace().equals(place));
    }

    @Test
    public void amphibianShouldHopeOffCorrect() {
        Place place = (Place) appContext.getBean("place");
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");
        amphibian.surfaceBreak(12.0);

        Assert.assertEquals(amphibian.getDeep(), 12.0, 1e-9);
    }

    @Test
    public void amphibianShouldAddAgeCorrect() {
        Age age = (Age) appContext.getBean("age1");

        Amphibian amphibian = (Amphibian) appContext.getBean("amphibianWithAge");
        amphibian.addAge(age);

        Assert.assertTrue(amphibian.getAge().getDay() == 20 && amphibian.getAge().getMonth() == 4 && amphibian.getAge().getYear() == 2);
    }

    @Test
    public void shouldSetDeepCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibianWithDeep");

        Assert.assertEquals(amphibian.getDeep(), 10.0, 1e-9);
    }


    @Test
    public void shouldSwimUnderCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibian");
        amphibian.swimUnder((Amphibian) appContext.getBean("amphibian"));

    }

    @Test
    public void shouldSetPlaceCorrect() {
        Amphibian amphibian = (Amphibian) appContext.getBean("amphibianWithPlace");
        Place place = (Place) appContext.getBean("place");

        Assert.assertEquals(amphibian.getPlace(), place);
    }



}
