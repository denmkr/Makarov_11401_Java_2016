package work004;

import work004.interfaces.AircraftTakeable;
import work004.interfaces.Position;
import work004.interfaces.Vehicle;

import java.util.ArrayList;

/**
 * Created by Denis on 25.02.16.
 */
public class Airport implements Position, AircraftTakeable {

    ArrayList<Place> freeLines;
    Trap trap;

    public Airport() {
        trap = new Trap();
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

    public ArrayList<Place> getFreeLines() {
        return freeLines;
    }

    public Trap getTrap() {
        return trap;
    }

    public void sendTrap(Aircraft aircraft) { // Подготовить трап
        trap.goTo(aircraft);
    }

    public void setFreeLines(ArrayList<Place> freeLines) {
        this.freeLines = freeLines;
    }

    public void setTrap(Trap trap) {
        this.trap = trap;
    }
}
