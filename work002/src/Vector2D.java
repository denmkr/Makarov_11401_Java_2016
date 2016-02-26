/**
 * Created by Denis on 23.02.16.
 */
public class Vector2D {

    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D getSum(Vector2D vector) {
        return new Vector2D(this.x + vector.getX(), vector.getY() + this.y);
    }

    public boolean equals(Object vector) {
        try {
            Vector2D vector2 = (Vector2D) vector;
            return (x == vector2.getX() && y == vector2.getY());
        } catch (ClassCastException e) {
            return false;
        }

    }

}