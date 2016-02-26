package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.*;
import work004.interfaces.Human;
import work004.interfaces.Vehicle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AmphibianTest {

    @Test
    public void amphibianShouldBeEmpty() {
        Amphibian amphibian = new Amphibian();

        Assert.assertTrue(amphibian.getPilot() == null && amphibian.getNavigator() == null);
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Amphibian amphibian = new Amphibian(pilot, navigator);

        Assert.assertFalse(amphibian.getDrivers().isEmpty());
    }

    @Test
    public void amphibianShouldStartCorrect() {
        Amphibian amphibian = new Amphibian();
        amphibian.start();

        Assert.assertTrue(amphibian.isStarted());
    }

    @Test
    public void amphibianShouldStopCorrect() {
        Amphibian amphibian = new Amphibian();
        amphibian.start();
        amphibian.stop();

        Assert.assertFalse(amphibian.isStarted());
    }

    @Test
    public void amphibianShouldChangeSpeed() {
        Amphibian amphibian = new Amphibian();
        amphibian.setSpeed(300.0);

        Assert.assertEquals(amphibian.getSpeed(), 300, 1e-9);
    }

    @Test
    public void amphibianShouldChangePosition() {
        Place place = mock(Place.class);
        Amphibian amphibian = new Amphibian();
        amphibian.setPlace(place);

        Assert.assertEquals(amphibian.getPlace(), place);
    }

    @Test
    public void amphibianShouldDestroyCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Amphibian amphibian = new Amphibian(pilot, navigator);
        amphibian.setSpeed(10.0);
        amphibian.destroy();

        Assert.assertTrue(amphibian.getSpeed() == 0 && amphibian.getPilot() == null && amphibian.getNavigator() == null && !amphibian.isStarted());
    }

    @Test
    public void amphibianShouldAddDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Amphibian amphibian = new Amphibian();
        amphibian.addDrivers(pilot, navigator);

        Assert.assertFalse(amphibian.getDrivers().isEmpty());
    }

    @Test
    public void amphibianShouldGetDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Amphibian amphibian = new Amphibian(pilot, navigator);

        Assert.assertFalse(amphibian.getDrivers().isEmpty());
    }

    @Test
    public void amphibianShouldRemoveDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Amphibian amphibian = new Amphibian(pilot, navigator);
        amphibian.removeDrivers();

        Assert.assertTrue(amphibian.getPilot() == null && amphibian.getNavigator() == null);
    }

    @Test
    public void amphibianShouldAddDriverCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Amphibian amphibian = new Amphibian(pilot, navigator);

        Pilot pilot1 = mock(Pilot.class);
        amphibian.setPilot(null);
        amphibian.addDriver(pilot1);

        Assert.assertEquals(amphibian.getDrivers().get(0), pilot1);
    }


    @Test
    public void amphibianShouldAddPassengerCorrect() {
        Human passenger = mock(Human.class);

        Amphibian amphibian = new Amphibian();
        amphibian.addPassenger(passenger);

        Assert.assertEquals(amphibian.getPassengersCount(), 1);
    }

    @Test
    public void amphibianShouldPlungeCorrect() {
        Place place = mock(Place.class);
        Amphibian amphibian = new Amphibian();
        amphibian.plunge(place);

        Assert.assertTrue(amphibian.getPlace().equals(place));
    }

    @Test
    public void amphibianShouldHopeOffCorrect() {
        Place place = mock(Place.class);
        Amphibian amphibian = new Amphibian();
        amphibian.surfaceBreak(12.0);

        Assert.assertEquals(amphibian.getDeep(), 12.0, 1e-9);
    }

    @Test
    public void amphibianShouldAddAgeCorrect() {
        Age age = mock(Age.class);
        when(age.getDay()).thenReturn(10);
        when(age.getMonth()).thenReturn(1);
        when(age.getYear()).thenReturn(14);

        Amphibian amphibian = new Amphibian();
        amphibian.setAge(age);
        amphibian.addAge(age);

        Assert.assertTrue(amphibian.getAge().getDay() == 10 && amphibian.getAge().getMonth() == 1 && amphibian.getAge().getYear() == 14);
    }

    @Test
    public void shouldSetDeepCorrect() {
        Amphibian amphibian = new Amphibian();
        amphibian.setDeep(10.0);

        Assert.assertEquals(amphibian.getDeep(), 10.0, 1e-9);
    }


    @Test
    public void shouldSwimUnderCorrect() {
        Amphibian amphibian = new Amphibian();
        amphibian.swimUnder(mock(Vehicle.class));

    }

    @Test
    public void shouldSetPlaceCorrect() {
        Amphibian amphibian = new Amphibian();
        Place place = mock(Place.class);
        amphibian.setPlace(place);

        Assert.assertEquals(amphibian.getPlace(), place);
    }



}
