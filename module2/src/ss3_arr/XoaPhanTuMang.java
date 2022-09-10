package ss3_arr;

import java.util.Scanner;

public class XoaPhanTuMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[];
        System.out.println("Nhap do dai mang:");
        int doDai = scanner.nextInt();
        arr = new int[doDai];
        int index = 0;
        while (index < doDai) {
            System.out.print("Nhap phan tu thu " + (index + 1) + ":");
            arr[index] = scanner.nextInt();
            index++;
        }
        System.out.print("Mang ban dau: ");
        for (int elemnet : arr) {
            System.out.println(elemnet + " ");
        }
        System.out.println();
        System.out.print("Nhap vao phan tu can xoa:");
        int deleteElement = scanner.nextInt();
        int[] newArr = new int[doDai];
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
            if (arr[i] == deleteElement) {
                isExist = true;
                for (int j = 0; j < arr.length - 1; j++) {
                    newArr[j] = arr[j + 1];
                }
                break;
            }
        }
        if (!isExist) {
            System.out.println("ko co pt de xoa");
        } else {
            System.out.println("mang sau khi xoa: ");
            for (int element : newArr) {
                System.out.print(element + "  ");
            }
        }
    }
}
