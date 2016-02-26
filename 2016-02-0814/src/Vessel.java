import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class Vessel implements Vehicle {

    double speed;
    boolean started;
    Human pilot;
    ArrayList<Human> passengers;

    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
        started = false;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void setPosition(Position position) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void addDrivers(Human pilot, Human navigator) {

    }

    @Override
    public ArrayList<Human> getDrivers() {
        return null;
    }

    @Override
    public void removeDrivers() {

    }

    @Override
    public void addDriver(Human pilot) {

    }

    @Override
    public void addPassenger(Human passenger) {

    }


}
