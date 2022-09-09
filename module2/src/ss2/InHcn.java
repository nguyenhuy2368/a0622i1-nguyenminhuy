package ss2;

import java.util.Scanner;

public class InHcn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap chieu dai");
        int dai = scanner.nextInt();
        System.out.println("nhap chieu rong");
        int rong = scanner.nextInt();
        for (int i = 0;i<rong;i++){
            for (int j = 0; j<dai;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
