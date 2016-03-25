package task007;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import task007.interfaces.Human;
import task007.interfaces.Vehicle;

/**
 * Created by Denis on 12.02.16.
 */
@Component
public class Navigator implements Human { // Штурман
    @Autowired
    Pilot partner;
    Age age;
    @Value("100")
    int weight;
    boolean blinded;
    @Autowired
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
