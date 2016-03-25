package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.*;
import task010.interfaces.Human;

import java.util.ArrayList;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AircraftTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void aircraftShouldBeEmpty() {
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");

        Assert.assertTrue(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Aircraft aircraft = (Aircraft) appContext.getBean("fullAircraft");

        Assert.assertFalse(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldStartCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        aircraft.start();

        Assert.assertTrue(aircraft.isStarted());
    }

    @Test
    public void aircraftShouldStopCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        aircraft.start();
        aircraft.stop();

        Assert.assertFalse(aircraft.isStarted());
    }

    @Test
    public void aircraftShouldChangeSpeed() {
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithSpeed300");

        Assert.assertEquals(aircraft.getSpeed(), 300, 1e-9);
    }

    @Test
    public void aircraftShouldChangePosition() {
        Place place = (Place) appContext.getBean("place");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithPlace");

        Assert.assertEquals(aircraft.getPlace(), place);
    }

    @Test
    public void aircraftShouldDestroyCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("fullAircraftWithSpeedHeight");

        AircraftCarrier carrier = (AircraftCarrier) appContext.getBean("carrier");
        carrier.shoot(10, aircraft);

        Assert.assertTrue(aircraft.getSpeed() == 0 && aircraft.getPilot() == null && aircraft.getNavigator() == null && aircraft.getHeight() == 0);
    }

    @Test
    public void aircraftShouldAddDriversCorrect() {
        Pilot pilot = (Pilot) appContext.getBean("pilot");
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        aircraft.addDrivers(pilot, navigator);

        Assert.assertFalse(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldGetDriversCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("fullAircraft");

        Assert.assertFalse(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldRemoveDriversCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("fullAircraft");
        aircraft.removeDrivers();

        Assert.assertTrue(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldAddDriverCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("fullAircraft");

        Pilot pilot = (Pilot) appContext.getBean("pilot");
        aircraft.setPilot(null);
        aircraft.addDriver(pilot);

        Assert.assertEquals(aircraft.getDrivers().get(0), pilot);
    }


    @Test
    public void aircraftShouldAddPassengerCorrect() {
        Human passenger = (Human) appContext.getBean("passenger");

        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        aircraft.addPassenger(passenger);

        Assert.assertEquals(aircraft.getPassengersCount(), 1);
    }

    @Test
    public void aircraftShouldLandOnCorrect() {
        Place place = (Place) appContext.getBean("place");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        aircraft.landOn(place);

        Assert.assertTrue(aircraft.getHeight() == 0 && aircraft.getPlace().equals(place));
    }

    @Test
    public void aircraftShouldHopeOffCorrect() {
        Place place = (Place) appContext.getBean("place");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        aircraft.hopOff(place);

        Assert.assertTrue(aircraft.getHeight() == 10 && aircraft.getPlace().equals(place));
    }

    @Test
    public void aircraftShouldAddAgeCorrect() {
        Age age = (Age) appContext.getBean("age1");

        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithAge");
        aircraft.addAge(age);

        Assert.assertTrue(aircraft.getAge().getDay() == 20 && aircraft.getAge().getMonth() == 4 && aircraft.getAge().getYear() == 2);
    }

    @Test
    public void aircraftShouldGetPassengersCorrect() {
        ArrayList<Human> passengers = (ArrayList<Human>) appContext.getBean("passengers");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithPassengers");

        Assert.assertEquals(aircraft.getPassengers(), passengers);
    }

    @Test
    public void aircraftShouldSetPassengersCorrect() {
        ArrayList<Human> passengers = (ArrayList<Human>) appContext.getBean("passengers");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithPassengers");

        Assert.assertEquals(aircraft.getPassengers(), passengers);
    }


    @Test
    public void aircraftShouldSetNavigatorCorrect() {
        Navigator navigator = (Navigator) appContext.getBean("navigator");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithNavigator");

        Assert.assertEquals(aircraft.getNavigator(), navigator);
    }

    @Test
    public void aircraftShouldSetPlaceCorrect() {
        Place place = (Place) appContext.getBean("place");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithPlace");

        Assert.assertEquals(aircraft.getPlace(), place);
    }


    @Test
    public void aircraftShouldSetPilotCorrect() {
        Pilot pilot = (Pilot) appContext.getBean("pilot");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraftWithPilot");

        Assert.assertEquals(aircraft.getPilot(), pilot);
    }



}
