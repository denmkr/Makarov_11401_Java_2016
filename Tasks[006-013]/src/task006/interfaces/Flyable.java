package task006.interfaces;

import task006.Place;

/**
 * Created by Denis on 12.02.16.
 */
public interface Flyable {

    public void setHeight(double height);

    public void landOn(Place place);
    public void hopOff(Place place);

}
