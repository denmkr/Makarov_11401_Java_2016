import java.util.List;

/**
 * Created by Denis on 26.02.16.
 */
public class Student {
    private List<Lesson> lessons;
    private String name;
    private Institute institute;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Institute getInstitute() {
        return institute;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return name + " " + "study in" + institute;
    }
}
