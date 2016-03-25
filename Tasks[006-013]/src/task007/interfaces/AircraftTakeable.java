package task007.interfaces;

import task007.Place;

/**
 * Created by Denis on 12.02.16.
 */
public interface AircraftTakeable {

    public Place getFreeLine(); // Освободить полосу
    public boolean sendHelp(Vehicle vehicle); // Подослать помощь

}
