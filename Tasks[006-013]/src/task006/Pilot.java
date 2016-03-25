package task006;

import task006.interfaces.AircraftControllable;
import task006.interfaces.Human;
import task006.interfaces.Vehicle;

/**
 * Created by Denis on 12.02.16.
 */
public class Pilot implements Human, AircraftControllable {

    Age age;
    int weight;
    Navigator partner;
    Vehicle vehicle;
    boolean blinded;
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
