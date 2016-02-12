/**
 * Created by Denis on 12.02.16.
 */
public class Pilot implements Human {

    int age;
    int weight;
    Navigator partner;
    Vehicle vehicle;


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
