package ss4.bt.pt_bac_2;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(this.getB(), 2) - 4 * this.getA() * this.getC();
    }

    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            return (-this.getB() + Math.sqrt(this.getDiscriminant()) / 2 * this.getA());
        } else {
            return 0;
        }
    }

    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            return (-this.getB() - Math.sqrt(this.getDiscriminant()) / 2 * this.getA());
        } else {
            return 0;
        }

    }
}
