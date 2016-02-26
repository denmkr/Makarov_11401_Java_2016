package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.Place;

/**
 * Created by Denis on 26.02.16.
 */
public class PlaceTest {

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Place place = new Place("my place");
        Assert.assertEquals(place.getName(), "my place");
    }

    @Test
    public void constructorShouldNotHaveName() {
        Place place = new Place();
        Assert.assertEquals(place.getName(), null);
    }
}
