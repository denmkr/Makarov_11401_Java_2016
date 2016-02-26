/**
 * Created by Denis on 12.02.16.
 */
public class Main {

    public static void main(String[] args) {

        Aircraft aircraft = new Aircraft(); // Создаем самолет
        Pilot pilot = new Pilot(); // Пилот
        Navigator navigator = new Navigator(); // Штурман
        aircraft.addDrivers(pilot, navigator); // Добавляем в самолет штурмана и пилота

        Place place = new Place(); // Создаем место для посадок
        AircraftCarrier aircraftCarrier = new AircraftCarrier(); // Создаем авианосца

        aircraft.landOn(place); // Самолет садится на землю

        aircraft.hopOff(place); // Взлетает с земли

        Vehicle submarine = new Submarine(); // Создаем подлодку


        Aircraft opponentAircraft = new Aircraft(); // Создаем вражеский самолет
        aircraftCarrier.releaseProtectionTo(opponentAircraft); // Авианосец выпускает защиту против вражеского самолета
        Airport airport = new Airport();
        pilot.requestLanding(aircraft);
        aircraft.landOn(place); // Самолет садится на авианосец


    }

}
