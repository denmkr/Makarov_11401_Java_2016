package task007;

import task007.interfaces.Human;

import java.util.ArrayList;

/**
 * Created by Denis on 25.02.16.
 */
public class Flash { // Вспышка

    public void releaseTo(ArrayList<Human> drivers) {
        for (int i=0; i<drivers.size(); i++) {
            drivers.get(i).setBlinded(true);
        }

    }
}
