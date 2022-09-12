package _3_array.bt;

import java.util.Scanner;

public class TimMaxMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Nhap mang
        System.out.print("Nhap vao do rong cua mang: ");
        int rong = scanner.nextInt();
        System.out.print("Nhap vao do dai cua mang: ");
        int dai = scanner.nextInt();
        int[][] arr = new int[rong][dai];
        for (int i = 0; i < rong; i++) {
            for (int j = 0; j < dai; j++) {
                System.out.println("Phan tu thu (" + (i + 1) + "," + (j + 1) + "): ");
                arr[i][j] = scanner.nextInt();
            }
        }
        //Xuat mang
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        //Tim phan tu lon nhat
        int max = arr[0][0];
        int index1=0;
        int index2=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println("Gia tri lon nhat la: " + max + " tai vi tri " + index1 + "," + index2);
    }


}
