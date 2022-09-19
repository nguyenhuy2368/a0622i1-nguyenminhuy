package ss6_ke_thua.bt.lop_Circle_Cylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter(){
        return Math.PI*2*radius;
    }
    @Override
    public String toString() {
        return "A Circle with radius= "
                + getRadius()
                + " ,color: "
                + getColor();
    }
}
