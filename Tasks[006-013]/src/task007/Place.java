package task007;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import task007.interfaces.Position;

/**
 * Created by Denis on 25.02.16.
 */
@Component
public class Place implements Position {
    @Value("Ground")
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
