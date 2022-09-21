package ss7.bt.colorable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1.0, "green");
        shapes[1] = new Rectangle(3.0, 2.0, "black");
        shapes[2] = new Square("violet", 2.5);
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
