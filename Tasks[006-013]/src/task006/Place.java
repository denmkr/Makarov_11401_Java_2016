package task006;

import task006.interfaces.Position;

/**
 * Created by Denis on 25.02.16.
 */
public class Place implements Position {
    String name;

    public Place() {
    }

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
