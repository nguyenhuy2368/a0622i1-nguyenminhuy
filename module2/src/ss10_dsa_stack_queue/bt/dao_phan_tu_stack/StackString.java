package ss10_dsa_stack_queue.bt.dao_phan_tu_stack;

import java.util.Scanner;
import java.util.Stack;

public class StackString {
    public static void main(String[] args) {
        Stack<String> wStack=new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi" );
        String string = scanner.nextLine();
        String[]temp=string.split(" ");
        for (int i = 0; i <temp.length ; i++) {
            wStack.push(temp[i]);
        }
        for (int j = 0; j < temp.length; j++) {
            temp[j] =wStack.pop();
        }
        System.out.println(temp);
        
    }
}
