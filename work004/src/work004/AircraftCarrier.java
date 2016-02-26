package work004;

import work004.interfaces.AircraftTakeable;
import work004.interfaces.Position;
import work004.interfaces.Vehicle;
import work004.interfaces.Warable;

import java.util.ArrayList;

/**
 * Created by Denis on 12.02.16.
 */
public class AircraftCarrier implements Position, AircraftTakeable, Warable {

    ArrayList<Place> freeLines;
    ArrayList<Vehicle> vehicles;

    public AircraftCarrier() {
        freeLines = new ArrayList<Place>();
        for (int i=0; i<5; i++)
            freeLines.add(new Place());
    }

    @Override
    public Place getFreeLine() {
        return freeLines.get(0);
    }

    @Override
    public boolean sendHelp(Vehicle vehicle) {
        System.out.print("helping...");
        return true;
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

    public ArrayList<Place> getFreeLines() {
        return freeLines;
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setFreeLines(ArrayList<Place> freeLines) {
        this.freeLines = freeLines;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
