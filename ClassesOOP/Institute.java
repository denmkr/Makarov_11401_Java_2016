/**
 * Created by Denis on 26.02.16.
 */
public class Institute {
    private String name;

    public Institute() {
    }

    public Institute(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
