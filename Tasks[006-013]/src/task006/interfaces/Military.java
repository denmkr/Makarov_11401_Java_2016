package task006.interfaces;

/**
 * Created by Denis on 25.02.16.
 */
public interface Military {
    public void requestHelp(Position position);
    public void requestShoot(Vehicle vehicle);
    public void shoot(Human human);
}
