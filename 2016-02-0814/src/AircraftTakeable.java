/**
 * Created by Denis on 12.02.16.
 */
public interface AircraftTakeable {

    public void freeLaneFor(Vehicle vehicle); // Освободить полосу
    public void shoot(int count, Vehicle vehicle);
    public void releaseProtectionTo(Vehicle vehicle); // Выпустить защиту

}
