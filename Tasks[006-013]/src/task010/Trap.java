package task010;

/**
 * Created by Denis on 25.02.16.
 */
public class Trap {

    Aircraft aircraft;

    public Trap() {
        aircraft = new Aircraft();
    }

    public void goTo(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
