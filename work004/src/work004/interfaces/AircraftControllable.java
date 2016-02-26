package work004.interfaces;

import work004.Aircraft;
import work004.Airport;

/**
 * Created by Denis on 25.02.16.
 */
public interface AircraftControllable { // Умеющий управлять самолетом

    public void pullWheel();
    public void pushWheel();
    public void flyBy(Aircraft aircraft);
    public void requestLanding(Airport airport); // Запросить посадку
}
