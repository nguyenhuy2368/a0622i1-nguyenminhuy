package ss3_arr;

import java.util.Scanner;

public class ThemPtMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr;
        System.out.print("Nhap do dai mang:");
        int doDai = scanner.nextInt();
        arr = new int[doDai];
        int index = 0;
        while (index < doDai) {
            System.out.print("Nhap phan tu thu " + (index + 1) + " : ");
            arr[index] = scanner.nextInt();
            index++;
        }
        System.out.print("Mang ban dau: ");
        outputArray(arr);
    }

    public static void outputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d", arr[i]);
        }
        System.out.println();
    }

    public static void inputArray(int[] arr, Scanner scanner) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhap vao phan tu thu "+ i + " : ");
            arr[i] = scanner.nextInt();
        }
    }
}
