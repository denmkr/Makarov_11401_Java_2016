import java.net.SocketPermission;
import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class Aircraft implements Flyable, Vehicle {

    double height; // высота полета
    double speed;
    Age age;
    Human pilot;
    Human navigator;
    ArrayList<Human> passengers;

    Position place; // Место нахождения

    boolean started; // Запущен ли двигатель


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
        this.place = position;
    }

    @Override
    public void destroy() {
        height = 0;
        speed = 0;
        stop();
        removeDrivers();
    }

    @Override
    public void addDrivers(Human pilot, Human navigator) {
        this.pilot =  pilot;
        this.navigator = navigator;
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
        pilot = null;
        navigator = null;
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
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void landOn(Place place) {
        this.place = place;
        height = 0.0;
    }

    @Override
    public void hopOff(Place place) {
        this.place = place;
        height = 2.0;
    }

    public int getPassengersCount() {
        return passengers.size();
    }

    public void addAge(Age age) {
        this.age.addAge(age);
    }

}
