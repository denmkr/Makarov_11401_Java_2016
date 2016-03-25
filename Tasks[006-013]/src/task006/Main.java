package task006;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import task006.interfaces.Vehicle;

/**
 * Created by Denis on 12.02.16.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("task006/spring-config-task006.xml");
        Aircraft aircraft = (Aircraft) appContext.getBean("aircraft"); // Создаем самолет
        Pilot pilot = (Pilot) appContext.getBean("pilot"); // Пилот
        Navigator navigator = (Navigator) appContext.getBean("navigator"); // Штурман

        Place place = (Place) appContext.getBean("place"); // Создаем место для посадок
        AircraftCarrier aircraftCarrier = (AircraftCarrier) appContext.getBean("aircraftCarrier"); // Создаем авианосца

        aircraft.landOn(place); // Самолет садится на землю
        aircraft.hopOff(place); // Взлетает с земли

        Vehicle submarine = (Submarine) appContext.getBean("submarine"); // Создаем подлодку

        Aircraft opponentAircraft = (Aircraft) appContext.getBean("opponentAircraft"); // Создаем вражеский самолет
        aircraftCarrier.releaseProtectionTo(opponentAircraft); // Авианосец выпускает защиту против вражеского самолета
        Airport airport = (Airport) appContext.getBean("airport");
        pilot.requestLanding(airport);
        aircraft.landOn(place); // Самолет садится на авианосец

    }

}
