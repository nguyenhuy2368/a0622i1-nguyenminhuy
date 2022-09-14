package ss4.th.lop_hcn;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter width:");
        double width = scanner.nextDouble();
        System.out.println("enter height:");
        double height = scanner.nextDouble();
        Rectangle hcn = new Rectangle(width,height);
        System.out.println("hcn: "+hcn.display());
        System.out.println("perimeter: "+hcn.getPerimeter());
        System.out.println("area: "+hcn.getArea());
    }

}
