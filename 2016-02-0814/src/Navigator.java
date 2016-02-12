/**
 * Created by Denis on 12.02.16.
 */
public class Navigator implements Human { // Штурман
    Pilot partner;
    Vehicle vehicle;
    int age;
    int weight;

    @Override
    public void sitDown(Vehicle vehicle) {
        System.out.print("sit in aircraft");
    }

    @Override
    public void getOut(Vehicle vehicle) {
        System.out.print("get out aircraft");
    }

    @Override
    public void look(Vehicle vehicle) {
        System.out.print("look on aircraft");
    }
}
