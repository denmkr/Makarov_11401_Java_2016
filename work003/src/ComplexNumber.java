/**
 * Created by Denis on 23.02.16.
 */
public class ComplexNumber {

    private double a;
    private double b;
    private int id;

    public double getA() {
       return this.a;
    }

    public double getB() {
        return this.b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        if (b > 0) {
            return a + " + " + b + "i";
        } else {
            return a + " - " + Math.abs(b) + "i";
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.a == ((ComplexNumber) obj).getA() && this.b == ((ComplexNumber) obj).getB();
    }

    public void add2(ComplexNumber cn) {
        this.a += cn.a;
        this.b += cn.b;
    }

    public ComplexNumber add(ComplexNumber cn2) {
        ComplexNumber cn = new ComplexNumber(this.getA() + cn2.getA(), this.getB() + cn2.getB());
        return cn;
    }

    public void sub2(ComplexNumber cn) {
        this.a -= cn.a;
        this.b -= cn.b;
    }

    public ComplexNumber sub(ComplexNumber cn2) {
        ComplexNumber cn = new ComplexNumber(this.getA() - cn2.getA(), this.getB() - cn2.getB());
        return cn;
    }

    public void mult2(ComplexNumber cn) {
        double temp = this.a * cn.getA() - this.b * cn.getB();
        this.b = this.a * cn.getB() + this.b * cn.getA();
        this.a = temp;
    }

    public ComplexNumber mult(ComplexNumber cn2) {
        ComplexNumber cn = new ComplexNumber(this.getA() * cn2.getA() - this.getB() * cn2.getB(), this.getA() * cn2.getB() + this.getB() * cn2.getA());
        return cn;
    }

    public void div2(ComplexNumber cn) {
        double temp = (this.a * cn.getA() + this.b * cn.getB()) / (cn.getA() * cn.getA() + cn.getB() * cn.getB());
        this.b = (cn.getA() * this.b - cn.getB() * this.a) / (cn.getA() * cn.getA() + cn.getB() * cn.getB());
        this.a = temp;
    }

    public ComplexNumber div(ComplexNumber cn2) {
        ComplexNumber cn = new ComplexNumber(((this.a * cn2.getA() + this.b * cn2.getB()) / (cn2.getA() * cn2.getA() + cn2.getB() * cn2.getB())), (cn2.getA() * this.b - cn2.getB() * this.a) / (cn2.getA() * cn2.getA() + cn2.getB() * cn2.getB()));
        return cn;
    }

    public void multNumber2(double k) {
        this.a = k * this.a;
        this.b = k * this.b;
    }

    public ComplexNumber multNumber(double k) {
        ComplexNumber cn = new ComplexNumber(this.a * k, this.b * k);
        return cn;
    }

    public double length() {
        return Math.sqrt(this.getA() * this.getA() + this.getB() * this.getB());
    }

    public double cos() {
        return this.getA() / this.length();
    }

    public double sin() {
        return this.getB() / this.length();
    }

    public double arg() {
        return Math.toDegrees(Math.atan(this.b / this.a));
    }

    public void pow(double n) {
        double length = this.length();
        double arg = Math.toRadians(this.arg());
        this.a = Math.pow(length, n) * Math.cos(n * arg);
        this.b = Math.pow(length, n) * Math.sin(n * arg);
    }

    public ComplexNumber pow2(double n) {
        ComplexNumber cn = new ComplexNumber(Math.pow(this.length(), n) * Math.cos(n * Math.toRadians(this.arg())), Math.pow(this.length(), n) * Math.sin(n * Math.toRadians(this.arg())));
        return cn;
    }

}