import java.util.ArrayList;

/**
 * Created by Denis on 25.02.16.
 */
public class Airport implements Position, AircraftTakeable {

    ArrayList<Place> freeLines;
    Trap trap;

    public void sendTrap(Aircraft aircraft) { // Подготовить трап
        trap.goTo(aircraft);
    }

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
}
