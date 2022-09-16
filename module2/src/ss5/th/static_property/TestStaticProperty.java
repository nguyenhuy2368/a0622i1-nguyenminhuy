package static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car c1= new Car("Mazda3","Skyactiv3");
        System.out.println(Car.numberOfCars);
        Car c2= new Car("Mazda6","Skyactiv6");
        System.out.println(Car.numberOfCars);

    }
}
