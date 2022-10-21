package ss15_xu_ly_ngoai_le_debug.bt.IllegalTriangleException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exception_tam_giac {
    public static void input() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap canh thu 1 tam giac: ");
        int a = scanner.nextInt();
        System.out.println("nhap canh thu 2 tam giac: ");
        int b = scanner.nextInt();
        System.out.println("nhap canh thu 3 tam giac: ");
        int c = scanner.nextInt();
        if ((a < 0) || (b < 0) || (c < 0)) {
            throw new InputMismatchException();
        }
        if ((a + b < c) || (a + c < b) || (b + c < a)) {
            throw new InputMismatchException();
        }
    }

    public static void main(String[] args) {
        try {
            input();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
