package task007.interfaces;

import task007.Age;
import task007.Place;

/**
 * Created by Denis on 12.02.16.
 */
public interface Human {
    public void setAge(Age age);
    public void goTo(Place place);
    public void sayTo(Human human);
    public boolean sitDownInto(Vehicle vehicle);
    public boolean goOutFrom(Vehicle vehicle);
    public boolean isBlinded();
    public void setBlinded(boolean blinded);
}
