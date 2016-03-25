package task007;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import task007.interfaces.Flyable;
import task007.interfaces.Human;
import task007.interfaces.Vehicle;

import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
@Component
public class Aircraft implements Flyable, Vehicle {

    @Value("3")
    double height; // высота полета
    @Value("200")
    double speed;
    Age age;
    @Autowired
    Human pilot;
    @Autowired
    Human navigator;
    ArrayList<Human> passengers;

    Place place; // Место нахождения

    boolean started; // Запущен ли двигатель

    public Aircraft() {
        passengers = new ArrayList<Human>();
        age = new Age(0, 0, 0);
    }

    public Aircraft(Human pilot, Human navigator) {
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
        height = 10.0;
    }

    public int getPassengersCount() {
        return passengers.size();
    }

    public void addAge(Age age) {
        this.age.addAge(age);
    }

    public double getHeight() {
        return height;
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

    public Navigator getNavigator() {
        return (Navigator) navigator;
    }

    public ArrayList<Human> getPassengers() {
        return passengers;
    }

    public Place getPlace() {
        return place;
    }

    public boolean isStarted() {
        return started;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public void setPassengers(ArrayList<Human> passengers) {
        this.passengers = passengers;
    }

    public void setPlace(Place place) {
        this.place = place;
    }


}
