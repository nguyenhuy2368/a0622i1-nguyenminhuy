package ss2;

import java.util.Scanner;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong snt can in ra:");
        int N = 2;
        int cout = 0;
        int number = scanner.nextInt();
        while (cout<number){
            boolean check = true;
            for (int i=2 ; i<=Math.sqrt(N);i++){
                if (N%i==0){
                    check= false;
                    break;
                }
            }
            if (check){
                System.out.println(N);
                cout++;
            }
            N++;
        }
    }
}
