package ss1.bt;

import java.util.Scanner;

public class DoiTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so tien can doi ra vnd");
        int tygia = 25000;
        int Vnd = 0;
        int doi= scanner.nextInt();
        Vnd = doi* tygia;
        System.out.println(Vnd);
    }
}
