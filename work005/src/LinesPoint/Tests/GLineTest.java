package LinesPoint.Tests;

import LinesPoint.Client.GComponents.GLine;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Created by Denis on 24.02.16.
 */
public class GLineTest {

    @Test
    public void lineShouldSaveColor() {
        GLine line = new GLine();
        line.changeBackground(Color.black);

        Assert.assertEquals(line.color, Color.black);
    }

}
