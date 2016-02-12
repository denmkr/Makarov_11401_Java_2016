/**
 * Created by Denis on 12.02.16.
 */
public class Amphibian implements Rideable, Swimmable, Vehicle {

    int maxDeep;
    int capacity;
    Pilot pilot;
    Navigator navigator;
    float price;

    @Override
    public void plunge(float deep) {
        System.out.print("pluge");
    }

    @Override
    public void surfaceBreak(float speed) {
        System.out.print("surface break");
    }

    @Override
    public void swimUnder(Vehicle vehicle) {
        System.out.print("swim under");
    }

    @Override
    public void start() {
        System.out.print("starting");
    }

    @Override
    public void addDrivers(Pilot pilot, Navigator navigator) {
        this.navigator = navigator;
        this.pilot = pilot;
    }

    @Override
    public void removeDrivers() {
        navigator = null;
        pilot = null;
    }

    @Override
    public void addDriver(Driver driver) {

    }

}
