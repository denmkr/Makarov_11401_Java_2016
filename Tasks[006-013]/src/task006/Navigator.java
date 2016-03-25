package task006;

import task006.interfaces.Human;
import task006.interfaces.Vehicle;

/**
 * Created by Denis on 12.02.16.
 */
public class Navigator implements Human { // Штурман
    Pilot partner;
    Age age;
    int weight;
    boolean blinded;
    Place place;

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

    @Override
    public boolean isBlinded() {
        return blinded;
    }

    @Override
    public void setBlinded(boolean blinded) {
        this.blinded = blinded;
    }

    public Pilot getPartner() {
        return partner;
    }

    public Age getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public void setPartner(Pilot partner) {
        this.partner = partner;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Place getPlace() {
        return place;
    }
}
