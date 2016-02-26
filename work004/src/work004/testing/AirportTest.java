package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.*;
import work004.interfaces.Vehicle;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class AirportTest {

    @Test
    public void constructorShouldCreateFreeLines() {
        Airport airport = new Airport();

        Assert.assertTrue(airport.getFreeLines().size() == 5);
    }

    @Test
    public void shouldSendTrapCorrect() {
        Airport airport = new Airport();
        Aircraft aircraft = mock(Aircraft.class);

        airport.sendTrap(aircraft);

        Assert.assertEquals(airport.getTrap().getAircraft(), aircraft);
    }


    @Test
    public void shouldGiveFreeLineCorrect() {
        Airport airport = new Airport();

        Assert.assertEquals(airport.getFreeLine(), airport.getFreeLines().get(0));
    }

    @Test
    public void shouldSendHelpCorrect() {
        Airport airport = new Airport();
        Vehicle vehicle = mock(Vehicle.class);
        Assert.assertTrue(airport.sendHelp(vehicle));
    }

    @Test
    public void shouldSetFreeLinesCorrect() {
        Airport airport = new Airport();
        ArrayList<Place> lines = mock(ArrayList.class);
        lines.add(mock(Place.class));

        airport.setFreeLines(lines);
    }

    @Test
    public void shouldSetTrapCorrect() {
        Airport airport = new Airport();
        Trap trap = mock(Trap.class);
        airport.setTrap(trap);

        Assert.assertEquals(airport.getTrap(), trap);
    }


}
