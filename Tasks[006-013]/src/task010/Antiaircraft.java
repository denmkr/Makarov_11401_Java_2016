package task010;

import task010.interfaces.Vehicle;
import task010.interfaces.Weapon;

/**
 * Created by Denis on 25.02.16.
 */
public class Antiaircraft implements Weapon {
    @Override
    public void shoot(Vehicle vehicle) {
        vehicle.destroy();
    }

    @Override
    public void reload() {
        System.out.print("reloading...");
    }
}
