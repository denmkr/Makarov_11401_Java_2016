package task010;

import task010.interfaces.Diveable;
import task010.interfaces.Human;
import task010.interfaces.Position;
import task010.interfaces.Vehicle;

import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class Amphibian implements Diveable, Vehicle {

    double deep;
    boolean started;
    Human pilot;
    Age age;
    Human navigator;
    double speed;
    ArrayList<Human> passengers;

    Place place; // Место нахождения

    public Amphibian() {
        passengers = new ArrayList<Human>();
        place = new Place();
    }

    public Amphibian(Human pilot, Human navigator) {
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
        deep = 0;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void destroy() {
        pilot = null;
        navigator = null;
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

    public int getPassengersCount() {
        return passengers.size();
    }

    @Override
    public void setDeep(double deep) {
        this.deep = deep;
    }

    @Override
    public void plunge(Place place) {
        this.place = place;
    }

    @Override
    public void surfaceBreak(double deep) {
        this.deep = deep;
    }

    @Override
    public void swimUnder(Vehicle vehicle) {
        System.out.print(vehicle + " is near");
    }

    public void addAge(Age age) {
        this.age.addAge(age);
    }

    public double getDeep() {
        return deep;
    }

    public boolean isStarted() {
        return started;
    }

    public Human getPilot() {
        return pilot;
    }

    public Age getAge() {
        return age;
    }

    public Human getNavigator() {
        return navigator;
    }

    public double getSpeed() {
        return speed;
    }

    public ArrayList<Human> getPassengers() {
        return passengers;
    }

    public Position getPlace() {
        return place;
    }

    public void setPilot(Human pilot) {
        this.pilot = pilot;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setNavigator(Human navigator) {
        this.navigator = navigator;
    }

    public void setPassengers(ArrayList<Human> passengers) {
        this.passengers = passengers;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
