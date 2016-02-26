package work004;

import work004.interfaces.Human;
import work004.interfaces.Position;
import work004.interfaces.Vehicle;

import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class Vessel implements Vehicle {

    double speed;
    Age age;
    Human pilot;
    Human navigator;
    ArrayList<Human> passengers;

    Position place; // Место нахождения

    boolean started; // Запущен ли двигатель

    public Vessel() {
    }

    public Vessel(Human pilot, Human navigator) {
        this.pilot = pilot;
        this.navigator = navigator;
    }

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
    public void destroy() {
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
        if (pilot != null && navigator != null) {
            drivers.add(pilot);
            drivers.add(navigator);
        }
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


    public int getPassengersCount() {
        return passengers.size();
    }

    public void addAge(Age age) {
        this.age.addAge(age);
    }

    public double getSpeed() {
        return speed;
    }

    public Age getAge() {
        return age;
    }

    public Human getPilot() {
        return pilot;
    }

    public Human getNavigator() {
        return navigator;
    }

    public ArrayList<Human> getPassengers() {
        return passengers;
    }

    public Position getPlace() {
        return place;
    }

    public boolean isStarted() {
        return started;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setPilot(Human pilot) {
        this.pilot = pilot;
    }

    public void setNavigator(Human navigator) {
        this.navigator = navigator;
    }

    public void setPassengers(ArrayList<Human> passengers) {
        this.passengers = passengers;
    }

    public void setPlace(Position place) {
        this.place = place;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
}
