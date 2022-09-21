package ss7.bt.resizeable;

public abstract class Shape implements Resizeable {
    private String color = "green";
//    private boolean filled = true;

    public Shape() {
    }

//    public Shape(String color, boolean filled) {
//        this.color = color;
//        this.filled = filled;
//    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    public boolean isFilled() {
//        return filled;
//    }
//
//    public void setFilled(boolean filled) {
//        this.filled = filled;
//    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
//                + (isFilled() ? "filled" : "not filled")
                ;
    }
}
