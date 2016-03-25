package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.*;
import task010.interfaces.Vehicle;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AircraftCarrierTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void constructorShouldCreateFreeLines() {
        AircraftCarrier carrier = (AircraftCarrier) appContext.getBean("carrier");

        Assert.assertEquals(carrier.getFreeLines().size(), 5);
    }

    @Test
    public void shouldGetFreeLineCorrect() {
        AircraftCarrier carrier = (AircraftCarrier) appContext.getBean("carrier");
        Assert.assertTrue(carrier.getFreeLine()!=null);
    }

    @Test
    public void shouldReleaseProtectionCorrect() {
        AircraftCarrier carrier = (AircraftCarrier) appContext.getBean("carrier");
        Vehicle vehicle = (Aircraft) appContext.getBean("aircraft");
        carrier.releaseProtectionTo(vehicle);

        Assert.assertTrue(true);
    }

    @Test
    public void shouldGetVehicleCountCorrect() {
        AircraftCarrier carrier = (AircraftCarrier) appContext.getBean("carrier");
        ArrayList vehicles = (ArrayList) appContext.getBean("vehicles");
        carrier.setVehicles(vehicles);
        Assert.assertEquals(carrier.getVehicleCount(), 1);
    }

    @Test
    public void shouldSendHelpCorrect() {
        AircraftCarrier carrier = (AircraftCarrier) appContext.getBean("carrier");

        Assert.assertTrue(carrier.sendHelp(mock(Vehicle.class)));
    }

    @Test
    public void shouldGetFreeLinesCorrect() {
        AircraftCarrier carrier = (AircraftCarrier) appContext.getBean("carrier");
        ArrayList<Place> lines = (ArrayList) appContext.getBean("lines");
        carrier.setFreeLines(lines);

        Assert.assertEquals(carrier.getFreeLines(), lines);
    }




}
