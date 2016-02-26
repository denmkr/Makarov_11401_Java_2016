/**
 * Created by Denis on 12.02.16.
 */
public class Navigator implements Human { // Штурман
    Pilot partner;
    Age age;
    int weight;

    @Override
    public void setAge(Age age) {
        this.age = age;
    }

    @Override
    public void goTo(Position position) {

    }

    @Override
    public void sayTo(Human human) {

    }

    @Override
    public void sitDownInto(Vehicle vehicle) {

    }

    @Override
    public void goOutFrom(Vehicle vehicle) {

    }

    @Override
    public void blind() {

    }
}
