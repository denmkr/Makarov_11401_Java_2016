package task007;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 12.02.16.
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        Aircraft aircraft = (Aircraft) context.getBean("aircraft"); // Создаем самолет
        aircraft.setAge((Age) context.getBean("aircraftAge"));

        Pilot pilot = (Pilot) context.getBean(Pilot.class); // Пилот
        Navigator navigator = (Navigator) context.getBean(Navigator.class); // Штурман

        pilot.setAge((Age) context.getBean("pilotAge"));
        navigator.setAge((Age) context.getBean("navigatorAge"));

        Place place = (Place) context.getBean(Place.class); // Создаем место для посадок
        AircraftCarrier aircraftCarrier = (AircraftCarrier) context.getBean("aircraftCarrier"); // Создаем авианосца

        aircraft.landOn(place); // Самолет садится на землю
        aircraft.hopOff(place); // Взлетает с земли

        Submarine submarine = (Submarine) context.getBean("submarine"); // Создаем подлодку

        Aircraft opponentAircraft = (Aircraft) context.getBean("opponentAircraft"); // Создаем вражеский самолет
        aircraftCarrier.releaseProtectionTo(opponentAircraft); // Авианосец выпускает защиту против вражеского самолета
        Airport airport = (Airport) context.getBean("airport");
        pilot.requestLanding(airport);
        aircraft.landOn(place); // Самолет садится на авианосец


    }

}
