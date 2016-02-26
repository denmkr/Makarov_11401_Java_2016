/**
 * Created by Denis on 12.02.16.
 */
public interface Human {
    public void setAge(Age age);
    public void goTo(Position position);
    public void sayTo(Human human);
    public void sitDownInto(Vehicle vehicle);
    public void goOutFrom(Vehicle vehicle);
    public void blind(); // Ослеплены
}
