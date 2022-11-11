package test.service;

import test.ReadAndWrite;
import test.RegexData;
import test.model.GiayDangKy;
import test.model.OTo;
import test.model.XeTai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GiayDangKyService {
    public static Scanner sc = new Scanner(System.in);
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static List<GiayDangKy> giayDangKyList = ReadAndWrite.readFileGiayDangKy("D:\\codegym\\module2\\introduction\\src\\test\\dkgplx.csv");
    public static List<OTo> oToList = ReadAndWrite.readFileOTo("D:\\codegym\\module2\\introduction\\src\\test\\phuongTien.csv");
    public static List<XeTai> xeTais = ReadAndWrite.readFileXeTai("D:\\codegym\\module2\\introduction\\src\\test\\phuongTien.csv");
    public static final String TEN = "[[A-Z]\\w+\\s]+";
    public static final String SO_DK = "[A-Z]\\d-\\d{4}";

    public static void dangKyMoiOTo() throws ParseException {
        for (GiayDangKy giayDangKy : giayDangKyList) {
            System.out.println(giayDangKy.toString());
        }
        boolean check = true;
        String soDK = "";
        do {
            System.out.println("mời nhập số đăng ký :");
            soDK = RegexData.regex(sc.nextLine(), SO_DK, "Nhập sai định dạng Yx-xxxx");
            check = false;
            for (GiayDangKy giayDangKy : giayDangKyList) {
                if (soDK.equals(giayDangKy.getSoDK())) {
                    System.out.println("số đăng ký đã tồn tai");
                    check = true;
                }
            }
        } while (check);
        System.out.println("nhập tên chủ xe :");
        String tenChuXe = RegexData.regex(sc.nextLine(), TEN, "Nhập sai định dạng Nguyen Van A");
        Date ngayDK = null;
        System.out.println("nhập ngày đăng ký :");
        while (ngayDK == null) {
            ngayDK = RegexData.validateDate(sc.nextLine());
        }
        for (OTo oTo : oToList) {
            System.out.println(oTo.toString());
        }
        String maPT = "";
        check = true;
        while (check) {
            check = true;
            System.out.println("mời chọn mã phương tiện :");
            maPT = sc.nextLine();
            for (OTo oTo : oToList) {
                if (oTo.getMaPT().equals(maPT)) {
                    check = false;
                }
            }
        }
        GiayDangKy giayDangKy = new GiayDangKy(soDK, tenChuXe, ngayDK, maPT);
        giayDangKyList.add(giayDangKy);
        ReadAndWrite.writeFileGiayDangKy(giayDangKyList, "D:\\codegym\\module2\\introduction\\src\\test\\dkgplx.csv");
    }

    public static void dangKyMoiXeTai() throws ParseException {
        boolean check = true;
        String soDK = "";
        do {
            System.out.println("mời nhập số đăng ký :");
            soDK = RegexData.regex(sc.nextLine(), SO_DK, "Nhập sai định dạng Yx-xxxx");
            check = false;
            for (GiayDangKy giayDangKy : giayDangKyList) {
                if (soDK.equals(giayDangKy.getSoDK())) {
                    System.out.println("số đăng ký đã tồn tai");
                    check = true;
                }
            }
        } while (check);
        System.out.println("nhập tên chủ xe :");
        String tenChuXe = RegexData.regex(sc.nextLine(), TEN, "Nhập sai định dạng Nguyen Van A");
        Date ngayDK = null;
        System.out.println("nhập ngày đăng ký :");
        while (ngayDK == null) {
            ngayDK = RegexData.validateDate(sc.nextLine());
        }
        for (XeTai xeTai : xeTais) {
            System.out.println(xeTai.toString());
        }
        check = true;
        String maPT = "";
        while (check) {
            check = true;
            System.out.println("mời chọn mã phương tiện :");
            maPT = sc.nextLine();
            for (XeTai xeTai : xeTais) {
                if (xeTai.getMaPT().equals(maPT)) {
                    check = false;
                }
            }
        }
        GiayDangKy giayDangKy = new GiayDangKy(soDK, tenChuXe, ngayDK, maPT);
        giayDangKyList.add(giayDangKy);
        ReadAndWrite.writeFileGiayDangKy(giayDangKyList, "D:\\codegym\\module2\\introduction\\src\\test\\dkgplx.csv");
    }

    public static void hienThi() {
        for (GiayDangKy giayDangKy : giayDangKyList) {
            for (OTo oTo : oToList) {
                if (giayDangKy.getMaPT().equals(oTo.getMaPT())) {
                    System.out.println(giayDangKy.toString() + oTo.toString());
                }
            }
            for (XeTai xeTai : xeTais) {
                if (giayDangKy.getMaPT().equals(xeTai.getMaPT())) {
                    System.out.println(giayDangKy.toString() + xeTai.toString());
                }
            }
        }
    }

    public static void xoa() {
        boolean check = true;
        while (check) {
            String soDK = "";
            System.out.println("mời nhập số đăng ký muốn xóa:");
            soDK = RegexData.regex(sc.nextLine(), SO_DK, "Nhập sai định dạng Yx-xxxx");
            check = false;
            for (int i = 0; i < giayDangKyList.size(); i++) {
                if (soDK.equals(giayDangKyList.get(i).getSoDK())) {
                    check = true;
                    System.out.println("bạn chắc chắn muốn xóa :");
                    System.out.println("1.Có :");
                    System.out.println("2.Khong :");
                    int choice = 0;
                    do {
                        check = false;
                        try {
                            System.out.println("mời chọn chức năng : ");
                            choice = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("nhập sai định dạng :");
                            check = true;
                        }
                    } while (check || choice < 1 || choice > 2);
                    switch (choice) {
                        case 1:
                            giayDangKyList.remove(i);
                            System.out.println("xoa thanh công");
                            ReadAndWrite.writeFileGiayDangKy(giayDangKyList, "D:\\codegym\\module2\\introduction\\src\\test\\dkgplx.csv");
                            return;
                        case 2:
                            System.out.println("bạn đã không xóa");
                            return;
                    }
                }
            }
            if (check == false) {
                System.out.println("id ko tồn tại");
                check=true;
            }
        }

    }
}
