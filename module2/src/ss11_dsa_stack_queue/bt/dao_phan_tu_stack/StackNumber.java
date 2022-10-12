package ss11_dsa_stack_queue.bt.dao_phan_tu_stack;

import java.util.Scanner;
import java.util.Stack;

public class StackNumber {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap do dai mang");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println(" Nhap phan tu thu " + (i + 1));
            arr[i] = scanner.nextInt();
        }
        for (int element : arr) {
            System.out.print(element + "\t");
        }
        // đua tu mang vao stack
        for (int j = 0; j < size; j++) {
            stack.push(arr[j]);
        }
        // stack ve mang ban dau
        for (int k = 0; k < size; k++) {
            arr[k] = stack.pop();
        }
        System.out.println();
        System.out.println("Mang sau khi xl:");
        for (int element : arr) {
            System.out.print(element + "\t");
        }
    }
}
