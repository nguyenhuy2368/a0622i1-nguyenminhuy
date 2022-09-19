package ss6_ke_thua.bt.lop_Circle_Cylinder;

public class Cylinder extends Circle{
    private double height ;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume (){
        return (getHeight()*getArea());
    }
    @Override
    public String toString(){
            return "Cylinder with volume: " + this.getVolume() +", "+ super.toString();
    }
}
