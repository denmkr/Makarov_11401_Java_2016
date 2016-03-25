package task006.interfaces;

import task006.Aircraft;
import task006.Airport;

/**
 * Created by Denis on 25.02.16.
 */
public interface AircraftControllable { // Умеющий управлять самолетом

    public void pullWheel();
    public void pushWheel();
    public void flyBy(Aircraft aircraft);
    public void requestLanding(Airport airport); // Запросить посадку
}
