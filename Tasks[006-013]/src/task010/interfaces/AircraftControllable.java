package task010.interfaces;

import task010.Aircraft;
import task010.Airport;

/**
 * Created by Denis on 25.02.16.
 */
public interface AircraftControllable { // Умеющий управлять самолетом

    public void pullWheel();
    public void pushWheel();
    public void flyBy(Aircraft aircraft);
    public void requestLanding(Airport airport); // Запросить посадку
}
