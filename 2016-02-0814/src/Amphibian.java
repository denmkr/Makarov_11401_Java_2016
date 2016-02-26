import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class Amphibian implements Diveable, Vehicle {

    double deep;
    boolean started;
    Human pilot;
    Human navigator;
    double speed;
    ArrayList<Human> passengers;

    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
        started = false;
        deep = 0;
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
        pilot = null;
        speed = 0;
        started = false;
    }

    @Override
    public void addDrivers(Human pilot, Human navigator) {
        this.navigator = navigator;
        this.pilot = pilot;
    }

    @Override
    public ArrayList<Human> getDrivers() {
        ArrayList<Human> drivers = new ArrayList<Human>();
        drivers.add(pilot);
        drivers.add(navigator);
        return drivers;
    }

    @Override
    public void removeDrivers() {
        navigator = null;
        pilot = null;
    }

    @Override
    public void addDriver(Human pilot) {
        this.pilot = pilot;
    }

    @Override
    public void addPassenger(Human passenger) {
        passengers.add(passenger);
    }

    @Override
    public void setDeep(double deep) {
        this.deep = deep;
    }

    @Override
    public void plunge() {

    }

    @Override
    public void surfaceBreak(double deep) {

    }

    @Override
    public void swimUnder(Vehicle vehicle) {

    }
}
