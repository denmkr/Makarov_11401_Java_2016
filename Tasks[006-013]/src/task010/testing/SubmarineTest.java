package task010.testing;

import org.junit.Assert;
import org.junit.Test;
import task010.*;
import task010.interfaces.Vehicle;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class SubmarineTest {

    @Test
    public void submarineShouldBeEmpty() {
        Submarine submarine = new Submarine();

        Assert.assertTrue(submarine.getPilot() == null && submarine.getNavigator() == null);
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Submarine submarine = new Submarine(pilot, navigator);

        Assert.assertTrue(submarine.getNavigator().equals(navigator) && submarine.getPilot().equals(pilot));
    }

    @Test
    public void submarineShouldStartCorrect() {
        Submarine submarine = new Submarine();
        submarine.start();

        Assert.assertTrue(submarine.isStarted());
    }

    @Test
    public void submarineShouldStopCorrect() {
        Submarine submarine = new Submarine();
        submarine.start();
        submarine.stop();

        Assert.assertFalse(submarine.isStarted());
    }

    @Test
    public void submarineShouldChangeSpeed() {
        Submarine submarine = new Submarine();
        submarine.setSpeed(300.0);

        Assert.assertEquals(submarine.getSpeed(), 300, 1e-9);
    }

    @Test
    public void submarineShouldChangePosition() {
        Place place = mock(Place.class);
        Submarine submarine = new Submarine();
        submarine.setPlace(place);

        Assert.assertEquals(submarine.getPlace(), place);
    }

    @Test
    public void submarineShouldDestroyCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Submarine submarine = new Submarine(pilot, navigator);
        submarine.setSpeed(10.0);
        submarine.destroy();

        Assert.assertTrue(submarine.getSpeed() == 0 && submarine.getPilot() == null && submarine.getNavigator() == null && !submarine.isStarted());
    }

    @Test
    public void submarineShouldAddDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Submarine submarine = new Submarine();
        submarine.addDrivers(pilot, navigator);

        Assert.assertFalse(submarine.getDrivers().isEmpty());
    }

    @Test
    public void submarineShouldGetDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Submarine submarine = new Submarine(pilot, navigator);

        Assert.assertFalse(submarine.getDrivers().isEmpty());
    }

    @Test
    public void submarineShouldRemoveDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Submarine submarine = new Submarine(pilot, navigator);
        submarine.removeDrivers();

        Assert.assertTrue(submarine.getPilot() == null && submarine.getNavigator() == null);
    }

    @Test
    public void submarineShouldAddDriverCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Submarine submarine = new Submarine(pilot, navigator);

        Pilot pilot1 = mock(Pilot.class);
        submarine.setPilot(null);
        submarine.addDriver(pilot1);

        Assert.assertEquals(submarine.getDrivers().get(0), pilot1);
    }


    @Test
    public void submarineShouldPlungeCorrect() {
        Place place = mock(Place.class);
        Submarine submarine = new Submarine();
        submarine.plunge(place);

        Assert.assertTrue(submarine.getPlace().equals(place));
    }

    @Test
    public void submarineShouldHopeOffCorrect() {
        Place place = mock(Place.class);
        Submarine submarine = new Submarine();
        submarine.surfaceBreak(12.0);

        Assert.assertEquals(submarine.getDeep(), 12.0, 1e-9);
    }


    @Test
    public void shouldSetDeepCorrect() {
        Submarine submarine = new Submarine();
        submarine.setDeep(10.0);

        Assert.assertEquals(submarine.getDeep(), 10.0, 1e-9);
    }


    @Test
    public void shouldSwimUnderCorrect() {
        Submarine submarine = new Submarine();
        submarine.swimUnder(mock(Vehicle.class));

    }

    @Test
    public void shouldSetPlaceCorrect() {
        Submarine submarine = new Submarine();
        Place place = mock(Place.class);
        submarine.setPlace(place);

        Assert.assertEquals(submarine.getPlace(), place);
    }


}
