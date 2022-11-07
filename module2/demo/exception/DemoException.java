package codegym.vn.exception;

import java.io.FileWriter;
import java.io.IOException;

public class DemoException {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("aaa.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                System.out.println(i);
            }
        }
        int []arr = {1, 3, 7};
        try {
//            System.out.println(arr[2]);
//            int a = 4 / 0;
            System.out.println(phepChia(2,0));
            System.out.println("done");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (MyException e) {
            System.out.println("My exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Da xu ly xong loi");
        }
        System.out.println("success");
    }

    public static float phepChia(int a, int b) throws MyException {
        if (b == 0) {
            throw new MyException("Khong the chia cho 0");
        }
        return a/(float)b;
    }
}
