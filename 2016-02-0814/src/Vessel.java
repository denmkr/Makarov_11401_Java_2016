/**
 * Created by Denis on 12.02.16.
 */
public class Vessel implements Vehicle, Swimmable {

    int maxSpeed;
    int weight;
    Human pilot;


    @Override
    public void plunge(float deep) {
        System.out.print("plunge");
    }

    @Override
    public void surfaceBreak(float speed) {
        System.out.print("surface with speed " + speed);
    }

    @Override
    public void swimUnder(Vehicle vehicle) {
        System.out.print("swim under");
    }

    @Override
    public void start() {
        System.out.print("starting vessel");
    }

    @Override
    public void addDrivers(Pilot pilot, Navigator navigator) {

    }

    @Override
    public void removeDrivers() {

    }

    @Override
    public void addDriver(Driver driver) {

    }


}
