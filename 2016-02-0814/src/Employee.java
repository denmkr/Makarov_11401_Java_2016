/**
 * Created by Denis on 12.02.16.
 */
public class Employee implements Human {

    @Override
    public void sitDown(Vehicle vehicle) {
        System.out.print("sit");
    }

    @Override
    public void getOut(Vehicle vehicle) {
        System.out.print("get out");
    }

    @Override
    public void look(Vehicle vehicle) {
        System.out.print("look");
    }
}
