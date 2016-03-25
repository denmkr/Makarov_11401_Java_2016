package task007;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import task007.interfaces.AircraftControllable;
import task007.interfaces.Human;
import task007.interfaces.Vehicle;

/**
 * Created by Denis on 12.02.16.
 */
@Component
public class Pilot implements Human, AircraftControllable {
    Age age;
    @Value("86")
    int weight;
    @Autowired
    Navigator partner;
    Vehicle vehicle;
    @Value("false")
    boolean blinded;
    @Autowired
    Place place;

    public Pilot() {
        place = new Place();
    }

    public boolean isBlinded() {
        return blinded;
    }

    public void setBlinded(boolean blinded) {
        this.blinded = blinded;
    }

    @Override
    public void pullWheel() {
        System.out.print("pull...");
    }

    @Override
    public void pushWheel() {
        System.out.print("push...");
    }

    @Override
    public void flyBy(Aircraft aircraft) {
        place = aircraft.place;
    }

    @Override
    public void requestLanding(Airport airport) {
        place = airport.getFreeLine();
    }

    @Override
    public void setAge(Age age) {
        this.age = age;
    }

    @Override
    public void goTo(Place place) {
        this.place = place;
    }

    @Override
    public void sayTo(Human human) {
        System.out.print(human + ", hello");
    }

    @Override
    public boolean sitDownInto(Vehicle vehicle) {
        vehicle.addDrivers(null, this);
        return true;
    }

    @Override
    public boolean goOutFrom(Vehicle vehicle) {
        vehicle.addDrivers(null, null);
        return true;
    }

    public Age getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public Navigator getPartner() {
        return partner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPartner(Navigator partner) {
        this.partner = partner;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Place getPlace() {
        return place;
    }
}
