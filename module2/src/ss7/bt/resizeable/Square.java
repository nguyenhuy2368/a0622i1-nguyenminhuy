package ss7.bt.resizeable;

public class Square extends Shape implements Resizeable {
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
    public double getArea() {
        return Math.pow(this.side, 2);
    }

    @Override
    public double resize(double percent) {
        return this.getArea() + percent / 100 * this.getArea();
    }
}
