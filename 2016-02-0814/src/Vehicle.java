/**
 * Created by Denis on 12.02.16.
 */
public interface Vehicle {
    public void start();

    public void addDrivers(Pilot pilot, Navigator navigator);

    public void removeDrivers();

    public void addDriver(Driver driver);


}
