package codegym.vn.stackqueue;

import java.util.Stack;

public class DemoStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(10);
        stack.push(20);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
