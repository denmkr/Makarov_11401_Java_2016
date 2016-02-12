import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
class Submarine implements Vehicle, Swimmable {

    int maxDeep;
    int capacity;
    ArrayList<Human> humansOnBoard;

    @Override
    public void plunge(float deep) {
        System.out.print("plunge");
    }

    @Override
    public void surfaceBreak(float speed) {
        System.out.print("surface with speed:" + speed);
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

    }

    @Override
    public void removeDrivers() {

    }

    @Override
    public void addDriver(Driver driver) {

    }


}
