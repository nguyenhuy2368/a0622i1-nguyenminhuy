package ss7.bt.colorable;

public class Square extends Shape implements Colorable {
    public double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    @Override
    public double getArea() {
        return 0;
    }
}
