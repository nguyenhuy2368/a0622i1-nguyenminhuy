package lingml;

import java.util.Scanner;

public class BienLai {
    private int chiSoCu;
    private int chiSoMoi;
    private double soTienPhaiTra; private KhachHang khachHang;

    public BienLai() {
    }

    public BienLai(int chiSoCu, int chiSoMoi, double soTienPhaiTra) {
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.soTienPhaiTra = soTienPhaiTra;
    }
    public void nhapBienLai() {
        khachHang = new KhachHang();
        khachHang.nhapKh();

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập chỉ số cũ: ");
            chiSoCu = scanner.nextInt();
            System.out.print("Nhập chỉ số mới: ");
            chiSoMoi = scanner.nextInt();
        } while (chiSoCu > chiSoMoi);

        soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 750;
    }

    public void hienThiBienLai() {
        khachHang.inKh();
        System.out.println("Chỉ số cũ: " + chiSoCu);
        System.out.println("Chỉ số mới: " + chiSoMoi);
        System.out.println("Số tiền phải trả: " + soTienPhaiTra);
    }
}
