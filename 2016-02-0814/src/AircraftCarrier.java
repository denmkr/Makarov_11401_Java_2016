import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class AircraftCarrier implements Position, AircraftTakeable, Warable {

    ArrayList<Place> freeLines;
    int vehicleCount;
    int length;
    int height;
    ArrayList<Vehicle> vehicles;

    public int getfreeLinesCount() {
        return freeLines.size();
    }

    @Override
    public void giveFreeLine(Place place) {
        if (getfreeLinesCount()!=0)
            freeLines.remove(getfreeLinesCount());
    }

    @Override
    public void sendHelp(Vehicle vehicle) {

    }

    @Override
    public void shoot(int count, Vehicle vehicle) {
        Antiaircraft antiaircraft = new Antiaircraft();
        for (int i=0; i<count; i++) {
            antiaircraft.shoot(vehicle);
        }
    }

    @Override
    public void releaseProtectionTo(Vehicle vehicle) {
        Flash protection = new Flash();
        protection.releaseTo(vehicle.getDrivers());
    }
}
