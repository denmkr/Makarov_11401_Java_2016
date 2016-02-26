package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.Age;
import work004.Navigator;
import work004.Place;
import work004.interfaces.Human;
import work004.interfaces.Vehicle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class NavigatorTest {

    @Test
    public void shouldSitDownIntoVehicleCorrect() {
        Navigator navigator = new Navigator();
        Vehicle vehicle = mock(Vehicle.class);

        Assert.assertTrue(navigator.sitDownInto(vehicle));
    }

    @Test
    public void shouldGoOutFromVehicleCorrect() {
        Navigator navigator = new Navigator();
        Vehicle vehicle = mock(Vehicle.class);

        Assert.assertTrue(navigator.goOutFrom(vehicle));
    }


    @Test
    public void shouldGoToCorrect() {
        Navigator navigator = new Navigator();
        Place place = mock(Place.class);
        navigator.goTo(place);

        Assert.assertEquals(navigator.getPlace(), place);
    }

    @Test
    public void shouldSayToCorrect() {
        Navigator navigator = new Navigator();
        navigator.sayTo(mock(Human.class));

        Assert.assertTrue(true);
    }

    @Test
    public void shouldSetAgeCorrect() {
        Navigator navigator = new Navigator();
        Age age = mock(Age.class);
        when(age.getDay()).thenReturn(1);
        when(age.getMonth()).thenReturn(4);
        when(age.getYear()).thenReturn(3);

        navigator.setAge(age);

        Assert.assertTrue(navigator.getAge().getDay() == 1 && navigator.getAge().getMonth() == 4 && navigator.getAge().getYear() == 3);
    }

    @Test
    public void shouldIsBlindedCorrect() {
        Navigator navigator = new Navigator();
        navigator.setBlinded(true);

        Assert.assertTrue(navigator.isBlinded());
    }
}
