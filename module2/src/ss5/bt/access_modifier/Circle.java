package ss5.bt.access_modifier;

public class Circle {
    private double radius = 1;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public double  getRadius(){
        return this.radius;
    }
    public double  getArea(){
        return Math.pow(Math.PI,2)*this.getRadius();
    }
}
