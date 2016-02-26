package LinesPoint.Tests;

import LinesPoint.Step;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Denis on 24.02.16.
 */
public class StepTest {

    @Test
    public void stepShouldBeSave() {
        Step step = Step.I;
        Assert.assertEquals(step, Step.I);
    }

}
