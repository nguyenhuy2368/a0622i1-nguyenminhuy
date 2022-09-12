package _3_array.bt;
import java.util.Scanner;
public class DemKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Nhap vao chuoi
        System.out.print("Nhap vao mot chuoi:");
        String chuoi = scanner.nextLine();
        //Nhap vao ky tu
        System.out.print("Nhap vao ky tu muon kiem tra:");
        char kytu = scanner.next().charAt(0);
        //Xuat chuoi
        System.out.println("Chuoi vua nhap: " + chuoi);
        //Xuat ky tu
        System.out.println("Ky tu can kiem tra: " + kytu);
        //Dem so lan xuat kien cua ky tu trong chuoi
        int count = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) == kytu) {
                count++;
            }
        }
        //Xuat ket qua
        System.out.println("So lan xuat hien ky tu: "+kytu+ " trong chuoi la: "+count);
    }
}
