/**
 * Created by Denis on 26.02.16.
 */
public class Lesson {
    private String name;

    public Lesson() {
    }

    public Lesson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
