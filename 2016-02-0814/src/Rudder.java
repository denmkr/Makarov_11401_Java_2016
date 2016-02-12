/**
 * Created by Denis on 12.02.16.
 */
public class Rudder implements Human { // Рулевой

    int age;
    int weight;
    Vehicle vehicle;


    @Override
    public void sitDown(Vehicle vehicle) {
        System.out.print("sit in vessel");
    }

    @Override
    public void getOut(Vehicle vehicle) {
        System.out.print("get out vessel");
    }

    @Override
    public void look(Vehicle vehicle) {
        System.out.print("look on vessel");
    }

}
