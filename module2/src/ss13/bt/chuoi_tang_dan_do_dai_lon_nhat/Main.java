package ss13.bt.chuoi_tang_dan_do_dai_lon_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        char ketqua = str.charAt(0);
        System.out.println(ketqua);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > ketqua) {
                System.out.println(str.charAt(i));
                ketqua = str.charAt(i);
            }
        }
    }
}
