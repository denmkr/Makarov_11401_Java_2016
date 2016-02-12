/**
 * Created by Denis on 12.02.16.
 */
public class Car implements Rideable, Vehicle {

    float price;
    int capacity;
    int age;
    Driver driver;

    @Override
    public void start() {
        System.out.print("starting car");
    }

    @Override
    public void addDrivers(Pilot pilot, Navigator navigator) {

    }

    @Override
    public void removeDrivers() {

    }

    @Override
    public void addDriver(Driver driver) {
        this.driver = driver;
    }

}
