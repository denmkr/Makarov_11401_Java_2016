/**
 * Created by Denis on 12.02.16.
 */
public class Aircraft implements Flyable, Vehicle {

    int weight;
    int age;
    Pilot pilot;
    Navigator navigator;
    int weaponCount;

    @Override
    public void start() {
        System.out.print("starting aircraft");
    }

    @Override
    public void addDrivers(Pilot pilot, Navigator navigator) {
        this.pilot =  pilot;
        this.navigator = navigator;
    }

    @Override
    public void removeDrivers() {
        pilot = null;
        navigator = null;
    }

    @Override
    public void addDriver(Driver driver) {

    }

    @Override
    public void landOn(Place place) {
        System.out.print("land on");
    }

    @Override
    public void hopOff(Place place) {
        System.out.print("hop off");
    }

    @Override
    public void flyOver(Vehicle vehicle) {
        System.out.print("fly over");
    }
}
