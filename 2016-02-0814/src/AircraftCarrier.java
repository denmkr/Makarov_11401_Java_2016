import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class AircraftCarrier implements AircraftTakeable, Swimmable, Place {

    int vehicleCount;
    int length;
    int height;
    ArrayList<Vehicle> vehicles;

    @Override
    public void freeLaneFor(Vehicle vehicle) {
        System.out.print("free Lane");
    }

    @Override
    public void shoot(int count, Vehicle vehicle) {
        System.out.print("shooting");
    }

    @Override
    public void releaseProtectionTo(Vehicle vehicle) {
        System.out.print("release protection");
    }

    @Override
    public void plunge(float deep) { // Погрузиться
        System.out.print("plunge");
    }

    @Override
    public void surfaceBreak(float speed) {
        System.out.print("surface");
    }

    @Override
    public void swimUnder(Vehicle vehicle) {
        System.out.print("swim under");
    }
}
