package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.*;
import work004.interfaces.Human;

import java.util.ArrayList;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AircraftTest {

    @Test
    public void aircraftShouldBeEmpty() {
        Aircraft aircraft = new Aircraft();

        Assert.assertTrue(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Aircraft aircraft = new Aircraft(pilot, navigator);

        Assert.assertFalse(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldStartCorrect() {
        Aircraft aircraft = new Aircraft();
        aircraft.start();

        Assert.assertTrue(aircraft.isStarted());
    }

    @Test
    public void aircraftShouldStopCorrect() {
        Aircraft aircraft = new Aircraft();
        aircraft.start();
        aircraft.stop();

        Assert.assertFalse(aircraft.isStarted());
    }

    @Test
    public void aircraftShouldChangeSpeed() {
        Aircraft aircraft = new Aircraft();
        aircraft.setSpeed(300.0);

        Assert.assertEquals(aircraft.getSpeed(), 300, 1e-9);
    }

    @Test
    public void aircraftShouldChangePosition() {
        Place place = mock(Place.class);
        Aircraft aircraft = new Aircraft();
        aircraft.setPlace(place);

        Assert.assertEquals(aircraft.getPlace(), place);
    }

    @Test
    public void aircraftShouldDestroyCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Aircraft aircraft = new Aircraft(pilot, navigator);
        aircraft.setSpeed(10.0);
        aircraft.setHeight(100.0);

        AircraftCarrier carrier = new AircraftCarrier();
        carrier.shoot(10, aircraft);

        Assert.assertTrue(aircraft.getSpeed() == 0 && aircraft.getPilot() == null && aircraft.getNavigator() == null && aircraft.getHeight() == 0);
    }

    @Test
    public void aircraftShouldAddDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Aircraft aircraft = new Aircraft();
        aircraft.addDrivers(pilot, navigator);

        Assert.assertFalse(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldGetDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Aircraft aircraft = new Aircraft(pilot, navigator);

        Assert.assertFalse(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldRemoveDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Aircraft aircraft = new Aircraft(pilot, navigator);
        aircraft.removeDrivers();

        Assert.assertTrue(aircraft.getDrivers().isEmpty());
    }

    @Test
    public void aircraftShouldAddDriverCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Aircraft aircraft = new Aircraft(pilot, navigator);

        Pilot pilot1 = mock(Pilot.class);
        aircraft.setPilot(null);
        aircraft.addDriver(pilot1);

        Assert.assertEquals(aircraft.getDrivers().get(0), pilot1);
    }


    @Test
    public void aircraftShouldAddPassengerCorrect() {
        Human passenger = mock(Human.class);

        Aircraft aircraft = new Aircraft();
        aircraft.addPassenger(passenger);

        Assert.assertEquals(aircraft.getPassengersCount(), 1);
    }

    @Test
    public void aircraftShouldLandOnCorrect() {
        Place place = mock(Place.class);
        Aircraft aircraft = new Aircraft();
        aircraft.landOn(place);

        Assert.assertTrue(aircraft.getHeight() == 0 && aircraft.getPlace().equals(place));
    }

    @Test
    public void aircraftShouldHopeOffCorrect() {
        Place place = mock(Place.class);
        Aircraft aircraft = new Aircraft();
        aircraft.hopOff(place);

        Assert.assertTrue(aircraft.getHeight() == 10 && aircraft.getPlace().equals(place));
    }

    @Test
    public void aircraftShouldAddAgeCorrect() {
        Age age = mock(Age.class);
        when(age.getDay()).thenReturn(10);
        when(age.getMonth()).thenReturn(1);
        when(age.getYear()).thenReturn(14);

        Aircraft aircraft = new Aircraft();
        aircraft.setAge(age);
        aircraft.addAge(age);

        Assert.assertTrue(aircraft.getAge().getDay() == 10 && aircraft.getAge().getMonth() == 1 && aircraft.getAge().getYear() == 14);
    }

    @Test
    public void aircraftShouldGetPassengersCorrect() {
        ArrayList<Human> passengers = mock(ArrayList.class);
        passengers.add(mock(Human.class));
        when(passengers.add(anyObject())).thenCallRealMethod();
        Aircraft aircraft = new Aircraft();
        aircraft.setPassengers(passengers);

        Assert.assertEquals(aircraft.getPassengers(), passengers);
    }

    @Test
    public void aircraftShouldSetPassengersCorrect() {
        ArrayList<Human> passengers = mock(ArrayList.class);
        passengers.add(mock(Human.class));
        Aircraft aircraft = new Aircraft();
        aircraft.setPassengers(passengers);

        Assert.assertEquals(aircraft.getPassengers(), passengers);
    }


    @Test
    public void aircraftShouldSetNavigatorCorrect() {
        Aircraft aircraft = new Aircraft();
        Navigator human = mock(Navigator.class);
        aircraft.setNavigator(human);

        Assert.assertEquals(aircraft.getNavigator(), human);
    }

    @Test
    public void aircraftShouldSetPlaceCorrect() {
        Aircraft aircraft = new Aircraft();
        Place place = mock(Place.class);
        aircraft.setPlace(place);

        Assert.assertEquals(aircraft.getPlace(), place);
    }


    @Test
    public void aircraftShouldSetPilotCorrect() {
        Aircraft aircraft = new Aircraft();

        Pilot pilot = mock(Pilot.class);
        aircraft.setPilot(pilot);

        Assert.assertEquals(aircraft.getPilot(), pilot);
    }



}
