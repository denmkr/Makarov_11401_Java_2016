/**
 * Created by Denis on 12.02.16.
 */
public class Young implements Human, Beginning {

    @Override
    public void getExpierence(Vehicle vehicle) {
        System.out.print("get expierence by Expierenced");
    }

    @Override
    public void askExperienced(Experienced human) {
        System.out.print("ask expierence by Expierenced");
    }

    @Override
    public void sitDown(Vehicle vehicle) {
        System.out.print("sit down");
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
