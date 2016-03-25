package task006.interfaces;

import task006.Place;

/**
 * Created by Denis on 12.02.16.
 */
public interface AircraftTakeable {

    public Place getFreeLine(); // Освободить полосу
    public boolean sendHelp(Vehicle vehicle); // Подослать помощь

}
