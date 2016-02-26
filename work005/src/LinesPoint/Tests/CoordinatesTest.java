package LinesPoint.Tests;

import LinesPoint.Coordinates;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Denis on 24.02.16.
 */
public class CoordinatesTest {

    @Test
    public void coordinatesShouldBeSave() {
        Coordinates coordinates = new Coordinates(1, 2);

        Assert.assertTrue(coordinates.getX() == 1 && coordinates.getY() == 2);
    }

    @Test
    public void stringShouldBeRight() {
        Coordinates coordinates = new Coordinates(1, 2);

        Assert.assertEquals(coordinates.toString(), "1,2");
    }

}
