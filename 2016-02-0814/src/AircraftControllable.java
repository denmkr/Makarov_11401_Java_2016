/**
 * Created by Denis on 25.02.16.
 */
public interface AircraftControllable { // Умеющий управлять самолетом

    public void pullWheel();
    public void pushWheel();
    public void flyBy(Aircraft aircraft);
    public void requestLanding(Aircraft aircraft); // Запросить посадку
}
