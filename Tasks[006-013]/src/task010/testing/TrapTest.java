package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.Aircraft;
import task010.Trap;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class TrapTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void constructorShouldBeCorrect() {
        Trap trap =(Trap) appContext.getBean("trap");

        Assert.assertTrue(trap.getAircraft() != null);
    }

    @Test
    public void shouldGotoCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        Trap trap = (Trap) appContext.getBean("trap");
        trap.goTo(aircraft);

        Assert.assertEquals(trap.getAircraft(), aircraft);
    }

    @Test
    public void shouldSetAndSetAircraftCorrect() {
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");
        Trap trap = (Trap) appContext.getBean("trapWithAircraft");

        Assert.assertEquals(trap.getAircraft(), aircraft);
    }

}
