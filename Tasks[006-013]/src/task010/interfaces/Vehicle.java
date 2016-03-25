package task010.interfaces;

import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public interface Vehicle {

    public void start();
    public void stop();
    public void setSpeed(double speed);
    public void destroy();

    public void addDrivers(Human pilot, Human navigator);
    public ArrayList<Human> getDrivers();
    public void removeDrivers();
    public void addDriver(Human pilot);
    public void addPassenger(Human passenger);

}
