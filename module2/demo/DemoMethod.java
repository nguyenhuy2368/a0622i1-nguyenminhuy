package codegym.vn.method;

import java.util.Scanner;

public class DemoMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1,56,7,9,10,15};
        outputArray(arr);
        arr = insertArray(arr, 5, 2);
        outputArray(arr);

    }

    public static void inputArray(int[] arr, Scanner scanner) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhap vao phan tu thu "+ i + " : ");
            arr[i] = scanner.nextInt();
        }
    }

    public static void outputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d", arr[i]);
        }
        System.out.println();
    }

    public static int[] insertArray(int[] arr, int k, int index) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < result.length; i++) {
            if (i < index) {
                result[i] = arr[i];
            } else if (i == index) {
                result[i] = k;
            } else {
                result[i] = arr[i - 1];
            }
        }

        return result;
    }
}
