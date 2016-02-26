package work004.testing;

import org.junit.Test;
import work004.Flash;
import work004.interfaces.Human;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 26.02.16.
 */
public class FlashTest {

    @Test
    public void shouldReleaseCorrect() {
        Flash flash = new Flash();
        ArrayList<Human> humans = mock(ArrayList.class);
        humans.add(mock(Human.class));
        flash.releaseTo(humans);
    }

}
