import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
class Submarine implements Vehicle, Diveable {

    double deep;
    int capacity;
    ArrayList<Human> humansOnBoard;

    @Override
    public void setDeep(double deep) {

    }

    @Override
    public void plunge() {

    }

    @Override
    public void surfaceBreak(double deep) {

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
    public void stop() {

    }

    @Override
    public void setSpeed(double speed) {

    }

    @Override
    public void setPosition(Position position) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void addDrivers(Human pilot, Human navigator) {

    }

    @Override
    public ArrayList<Human> getDrivers() {
        return null;
    }


    @Override
    public void removeDrivers() {

    }

    @Override
    public void addDriver(Human pilot) {

    }

    @Override
    public void addPassenger(Human passenger) {

    }


}
