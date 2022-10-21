package lingml;

import java.util.Scanner;

public class KhachHang {
    public String ten;
    public String diaChi;
    public int maCongTo;

    public KhachHang() {
    }

    public KhachHang(String ten, String diaChi, int maCongTo) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.maCongTo = maCongTo;
    }
    public void nhapKh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ten");
        ten=sc.nextLine();
        System.out.println("diachi");
        diaChi=sc.nextLine();
        System.out.println("macongto");
        maCongTo=sc.nextInt();
    }
    public void inKh(){
        System.out.println("ten "+ this.ten+" diachi "+ this.diaChi+" masoct "+ this.maCongTo);
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", maCongTo=" + maCongTo +
                '}';
    }
}
