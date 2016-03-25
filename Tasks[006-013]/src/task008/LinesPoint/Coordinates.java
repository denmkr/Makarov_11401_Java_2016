package task008.LinesPoint;

import task008.LinesPoint.Client.Client;
import org.junit.*;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Denis on 29.11.15.
 */

public class Coordinates implements Serializable {

    private int x;
    private int y;

    public String toString() {
        return x + "," + y;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}