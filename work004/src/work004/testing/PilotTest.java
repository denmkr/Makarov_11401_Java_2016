package work004.testing;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import work004.*;
import work004.interfaces.Human;
import work004.interfaces.Vehicle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class PilotTest {

    @Test
    public void shouldSitDownIntoVehicleCorrect() {
        Pilot pilot = new Pilot();
        Vehicle vehicle = mock(Vehicle.class);

        Assert.assertTrue(pilot.sitDownInto(vehicle));
    }

    @Test
    public void shouldGoOutFromVehicleCorrect() {
        Pilot pilot = new Pilot();
        Vehicle vehicle = mock(Vehicle.class);

        Assert.assertTrue(pilot.goOutFrom(vehicle));
    }


    @Test
    public void shouldGoToCorrect() {
        Pilot pilot = new Pilot();
        Place place = mock(Place.class);
        pilot.goTo(place);

        Assert.assertEquals(pilot.getPlace(), place);
    }

    @Test
    public void shouldSayToCorrect() {
        Pilot pilot = new Pilot();
        pilot.sayTo(mock(Human.class));

        Assert.assertTrue(true);
    }

    @Test
    public void shouldSetAgeCorrect() {
        Pilot pilot = new Pilot();
        Age age = mock(Age.class);
        when(age.getDay()).thenReturn(1);
        when(age.getMonth()).thenReturn(4);
        when(age.getYear()).thenReturn(3);

        pilot.setAge(age);

        Assert.assertTrue(pilot.getAge().getDay() == 1 && pilot.getAge().getMonth() == 4 && pilot.getAge().getYear() == 3);
    }

    @Test
    public void shouldIsBlindedCorrect() {
        Pilot pilot = new Pilot();
        pilot.setBlinded(true);

        Assert.assertTrue(pilot.isBlinded());
    }

    @Ignore
    @Test
    public void shouldRequestLanding() {
        Pilot pilot = new Pilot();
        Airport airport = mock(Airport.class);
        pilot.requestLanding(airport);

        Place place = mock(Place.class);
        when(airport.getFreeLine()).thenReturn(place);

        Assert.assertEquals(pilot.getPlace(), place);
    }

    @Test
    public void shouldPullWheel() {
        Pilot pilot = new Pilot();
        pilot.pullWheel();

        Assert.assertTrue(true);
    }

    @Test
    public void shouldPushWheel() {
        Pilot pilot = new Pilot();
        pilot.pushWheel();

        Assert.assertTrue(true);
    }
}
