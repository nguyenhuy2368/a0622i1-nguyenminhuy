package codegym.vn.maptree;

import java.util.HashSet;
import java.util.Set;

public class DemoHashSet {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        Product p1 = new Product(1, "Asus", "laptop");
        Product p2 = new Product(1, "Asus", "smartphone");
        Product p3 = new Product(2, "Dell", "laptop");
        Product p4 = new Product(3, "Toshiba", "laptop");
        Product p5 = new Product(4, "Asus", "laptop");
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);

        products.forEach(System.out::println);
    }
}
