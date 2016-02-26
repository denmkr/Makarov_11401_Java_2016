package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.*;
import work004.interfaces.Vehicle;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AircraftCarrierTest {

    @Test
    public void constructorShouldCreateFreeLines() {
        AircraftCarrier carrier = new AircraftCarrier();

        Assert.assertEquals(carrier.getFreeLines().size(), 5);
    }

    @Test
    public void shouldGetFreeLineCorrect() {
        AircraftCarrier carrier = new AircraftCarrier();
        Assert.assertTrue(carrier.getFreeLine()!=null);
    }

    @Test
    public void shouldReleaseProtectionCorrect() {
        AircraftCarrier carrier = new AircraftCarrier();
        Vehicle vehicle = mock(Vehicle.class);
        carrier.releaseProtectionTo(vehicle);

        Assert.assertTrue(true);
    }

    @Test
    public void shouldGetVehicleCountCorrect() {
        AircraftCarrier carrier = new AircraftCarrier();
        ArrayList<Vehicle> vehicles = mock(ArrayList.class);
        vehicles.add(mock(Vehicle.class));
        when(vehicles.size()).thenReturn(1);
        carrier.setVehicles(vehicles);
        Assert.assertEquals(carrier.getVehicleCount(), 1);
    }

    @Test
    public void shouldSendHelpCorrect() {
        AircraftCarrier carrier = new AircraftCarrier();

        Assert.assertTrue(carrier.sendHelp(mock(Vehicle.class)));
    }

    @Test
    public void shouldGetFreeLinesCorrect() {
        AircraftCarrier carrier = new AircraftCarrier();
        ArrayList<Place> lines = mock(ArrayList.class);
        Place place = mock(Place.class);
        lines.add(place);
        carrier.setFreeLines(lines);

        when(lines.get(anyInt())).thenReturn(place);

        Assert.assertEquals(carrier.getFreeLines(), lines);
    }




}
