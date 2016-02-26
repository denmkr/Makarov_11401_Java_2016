package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.Navigator;
import work004.Pilot;
import work004.Place;
import work004.Vessel;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class VesselTest {

    @Test
    public void vesselShouldBeEmpty() {
        Vessel vessel = new Vessel();

        Assert.assertTrue(vessel.getPilot() == null && vessel.getNavigator() == null);
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Vessel vessel = new Vessel(pilot, navigator);

        Assert.assertTrue(vessel.getNavigator().equals(navigator) && vessel.getPilot().equals(pilot));
    }

    @Test
    public void vesselShouldStartCorrect() {
        Vessel vessel = new Vessel();
        vessel.start();

        Assert.assertTrue(vessel.isStarted());
    }

    @Test
    public void vesselShouldStopCorrect() {
        Vessel vessel = new Vessel();
        vessel.start();
        vessel.stop();

        Assert.assertFalse(vessel.isStarted());
    }

    @Test
    public void vesselShouldChangeSpeed() {
        Vessel vessel = new Vessel();
        vessel.setSpeed(300.0);

        Assert.assertEquals(vessel.getSpeed(), 300, 1e-9);
    }

    @Test
    public void vesselShouldChangePosition() {
        Place place = mock(Place.class);
        Vessel vessel = new Vessel();
        vessel.setPlace(place);

        Assert.assertEquals(vessel.getPlace(), place);
    }

    @Test
    public void vesselShouldDestroyCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Vessel vessel = new Vessel(pilot, navigator);
        vessel.setSpeed(10.0);
        vessel.destroy();

        Assert.assertTrue(vessel.getSpeed() == 0 && vessel.getPilot() == null && vessel.getNavigator() == null && !vessel.isStarted());
    }

    @Test
    public void vesselShouldAddDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Vessel vessel = new Vessel();
        vessel.addDrivers(pilot, navigator);

        Assert.assertFalse(vessel.getDrivers().isEmpty());
    }

    @Test
    public void vesselShouldGetDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Vessel vessel = new Vessel(pilot, navigator);

        Assert.assertFalse(vessel.getDrivers().isEmpty());
    }

    @Test
    public void vesselShouldRemoveDriversCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Vessel vessel = new Vessel(pilot, navigator);
        vessel.removeDrivers();

        Assert.assertTrue(vessel.getPilot() == null && vessel.getNavigator() == null);
    }

    @Test
    public void vesselShouldAddDriverCorrect() {
        Pilot pilot = mock(Pilot.class);
        Navigator navigator = mock(Navigator.class);
        Vessel vessel = new Vessel(pilot, navigator);

        Pilot pilot1 = mock(Pilot.class);
        vessel.setPilot(null);
        vessel.addDriver(pilot1);

        Assert.assertEquals(vessel.getDrivers().get(0), pilot1);
    }



    @Test
    public void shouldSetPlaceCorrect() {
        Vessel vessel = new Vessel();
        Place place = mock(Place.class);
        vessel.setPlace(place);

        Assert.assertEquals(vessel.getPlace(), place);
    }


}

