package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.Aircraft;
import work004.Trap;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class TrapTest {

    @Test
    public void constructorShouldBeCorrect() {
        Trap trap = new Trap();

        Assert.assertTrue(trap.getAircraft() != null);
    }

    @Test
    public void shouldGotoCorrect() {
        Aircraft aircraft = mock(Aircraft.class);
        Trap trap = new Trap();
        trap.goTo(aircraft);

        Assert.assertEquals(trap.getAircraft(), aircraft);
    }

    @Test
    public void shouldSetAndSetAircraftCorrect() {
        Aircraft aircraft = mock(Aircraft.class);
        Trap trap = new Trap();
        trap.setAircraft(aircraft);

        Assert.assertEquals(trap.getAircraft(), aircraft);
    }

}
