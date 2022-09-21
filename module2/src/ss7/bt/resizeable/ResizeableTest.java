package ss7.bt.resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1.5, "red");
        shapes[1] = new Rectangle(2.0, 3.5, "blue");
        shapes[2] = new Square("green", 3.0);

        double random = Math.floor(Math.random()*100);
        for (Shape shape: shapes) {
            System.out.println("s ban dau "+ shape.getArea()+ " ,s resize "+shape.resize(random));
        }
    }
}
