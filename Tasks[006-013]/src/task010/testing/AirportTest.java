package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.*;
import task010.interfaces.Vehicle;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class AirportTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void constructorShouldCreateFreeLines() {
        Airport airport = (Airport) appContext.getBean("airport");

        Assert.assertTrue(airport.getFreeLines().size() == 5);
    }

    @Test
    public void shouldSendTrapCorrect() {
        Airport airport = (Airport) appContext.getBean("airport");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft");

        airport.sendTrap(aircraft);

        Assert.assertEquals(airport.getTrap().getAircraft(), aircraft);
    }


    @Test
    public void shouldGiveFreeLineCorrect() {
        Airport airport = (Airport) appContext.getBean("airport");

        Assert.assertEquals(airport.getFreeLine(), airport.getFreeLines().get(0));
    }

    @Test
    public void shouldSendHelpCorrect() {
        Airport airport = (Airport) appContext.getBean("airport");
        Vehicle vehicle = (Aircraft) appContext.getBean("aircraft");
        Assert.assertTrue(airport.sendHelp(vehicle));
    }

    @Test
    public void shouldSetFreeLinesCorrect() {
        Airport airport = (Airport) appContext.getBean("airportWithFreeLines");
        ArrayList<Place> lines = (ArrayList<Place>) appContext.getBean("lines");

        Assert.assertEquals(airport.getFreeLines(), lines);
    }

    @Test
    public void shouldSetTrapCorrect() {
        Airport airport = (Airport) appContext.getBean("airportWithTrap");
        Trap trap = (Trap) appContext.getBean("trap");

        Assert.assertEquals(airport.getTrap(), trap);
    }


}
