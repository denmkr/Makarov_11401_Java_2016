package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.Antiaircraft;
import work004.interfaces.Vehicle;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class AntiaircraftTest {

    @Test
    public void shouldShootCorrect() {
        Antiaircraft antiaircraft = new Antiaircraft();
        Vehicle vehicle = mock(Vehicle.class);
        antiaircraft.shoot(vehicle);

        Assert.assertTrue(true);
    }

    @Test
    public void shouldReloadCorrect() {
        Antiaircraft antiaircraft = new Antiaircraft();
        Vehicle vehicle = mock(Vehicle.class);
        antiaircraft.reload();

        Assert.assertTrue(true);
    }
}
