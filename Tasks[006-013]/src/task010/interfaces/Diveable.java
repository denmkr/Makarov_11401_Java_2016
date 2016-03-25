package task010.interfaces;

import task010.Place;

/**
 * Created by Denis on 12.02.16.
 */
public interface Diveable { // Способный погружаться

    public void setDeep(double deep);
    public void plunge(Place place); // Погрузиться
    public void surfaceBreak(double deep); // Выплыть
    public void swimUnder(Vehicle vehicle); // Проплыть под

}
