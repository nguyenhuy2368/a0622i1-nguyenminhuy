package testabc.service;

import testabc.models.GiayDangKy;
import testabc.models.Oto;
import testabc.models.PhuongTien;
import testabc.models.XeTai;
import testabc.utils.FileUtils;
import testabc.utils.RegexData;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PhuongTienService {
    private static final String SO_DANG_KY = "^[A-Z]\\d{1}-\\d{4}$";
    private static final String TEN ="^([a-z]{1,10})((\\s{1}[a-z]{1,10}){1,4})$";
    String giayDangKyUrl = "D:\\A0622I1\\module2\\src\\Thi\\data\\gdkpt.csv";
    private static List<PhuongTien> phuongTienList = FileUtils.readFilePhuongTien("D:\\A0622I1\\module2\\src\\Thi\\data\\phuongTien.csv");
    private static List<Oto> oToList = FileUtils.readFileOTo("D:\\A0622I1\\module2\\src\\Thi\\data\\phuongTien.csv");
    private static List<XeTai> xeTaiList = FileUtils.readFileXeTai("D:\\A0622I1\\module2\\src\\Thi\\data\\phuongTien.csv");
    private static List<GiayDangKy> giayDangKyList = FileUtils.readFile("D:\\A0622I1\\module2\\src\\Thi\\data\\gdkpt.csv");
    private static Scanner scanner = new Scanner(System.in);

    public void dangKy() {
        System.out.println("Lựa chọn : ");
        System.out.println("1.\tĐăng ký ô tô\n" +
                "2.\tĐăng ký xe tải\n" +
                "3.\tTrở về menu chính\n");
        System.out.println();
        dangKyPhuongTien();
    }

    public void dangKyPhuongTien() {
        String mess = null;
        try {
            System.out.printf("Your choice : ");
            int yourChoice = Integer.parseInt(scanner.nextLine());
            switch (yourChoice) {
                case 1:
                    dangKyOTo();
                    dangKy();
                    break;
                case 2:
                    dangKyXeTai();
                    dangKy();
                    break;
                case 3:
                    mess = "Back to menu";
                    break;
                default:
                    System.out.println("Choice Again !");
                    dangKy();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String dangKyOTo() {
        System.out.println("Đăng kí o to");
        try {

            String maDangKy = null;
            while (maDangKy == null) {
                maDangKy = inputMa();
            }
            System.out.printf("Họ và tên :");
            String hoTen = scanner.nextLine();
            Date ngayDangKy = null;
            while (ngayDangKy == null) {
                ngayDangKy = inputDate();
            }

            String maPhuongTien = getMaPhuongTien();
            while (maPhuongTien == null) {
                maPhuongTien = getMaPhuongTien();
            }
            GiayDangKy giayDangKy = new GiayDangKy(maDangKy, hoTen, ngayDangKy, maPhuongTien);
            giayDangKyList.add(giayDangKy);

            FileUtils.writeFileAccount(giayDangKyList, giayDangKyUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Add AccountLessor Fail");
        }
        return "Success";
    }

    public String dangKyXeTai() {
        System.out.println("Đăng kí xe tai");
        try {

            String maDangKy = null;
            while (maDangKy == null) {
                maDangKy = inputMa();
            }
            String hoTen = null;
            while (hoTen==null){
                hoTen=inputTen();
            }
            Date ngayDangKy = null;
            while (ngayDangKy == null) {
                ngayDangKy = inputDate();
            }

            String maPhuongTien = getMaPhuongTienXeTai();
            while (maPhuongTien == null) {
                maPhuongTien = getMaPhuongTienXeTai();
            }
            GiayDangKy giayDangKy = new GiayDangKy(maDangKy, hoTen, ngayDangKy, maPhuongTien);
            giayDangKyList.add(giayDangKy);

            FileUtils.writeFileAccount(giayDangKyList, giayDangKyUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Add AccountLessor Fail");
        }
        return "Success";
    }

    public void display() {
        for (GiayDangKy giayDangKy : giayDangKyList) {
            for (Oto oto : oToList) {
                if (giayDangKy.getMaPhuongTien().equals(oto.getMaPhuongTien())) {
                    System.out.println(giayDangKy.toString() + oto.toString());
                }
            }
            for (XeTai xeTai : xeTaiList) {
                if (giayDangKy.getMaPhuongTien().equals(xeTai.getMaPhuongTien())) {
                    System.out.println(giayDangKy.toString() + xeTai.toString());
                }
            }
        }
    }

    public void delete() {
        String maDangKy = null;
        try {
            while (maDangKy == null) {
                maDangKy = inputMa1();
            }
        } catch (Exception e) {
            System.out.println("đã lỗi");
        }
        for (int i = 0; i <giayDangKyList.size(); i++) {


            if (giayDangKyList.get(i).getSoDangKy().equals(maDangKy)) {
                System.out.println("bạn có chắc muốn xóa");
                System.out.println("1.Tôi muốn xóa");
                System.out.println("2.Tôi không muốn xóa");
                int choice = 0;
                do {
                    System.out.println("mời bạn quyết định");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("sai định dạng");
                    }
                } while (choice < 1 || choice > 2);
                switch (choice) {
                    case 1:
                        giayDangKyList.remove(i);
                        FileUtils.writeFileAccount(giayDangKyList, giayDangKyUrl);
                        break;
                    case 2:
                        break;
                }
            }
        }
    }

    public Date inputDate() {
        Date ngayDangKy = null;
        System.out.printf("Ngày Đăng Ký(dd/mm/yyyy) :");
        String dateAsString = scanner.nextLine();
        try {
            ngayDangKy = RegexData.validateDate(dateAsString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ngayDangKy;
    }
    public String inputMa1(){
        System.out.printf("Số Đăng Ký : ");
        String soDangKy = scanner.nextLine();
        String result = null;

        if (!soDangKy.matches(SO_DANG_KY)) {
            System.out.println("Nhập sai cú pháp (Yx-xxxx) !");
            return null;
        } else {
            result = soDangKy;
        }
        return result;
    }
    public String inputTen(){
        System.out.println("nhập tên :");
        String ten = scanner.nextLine();
        String result=null;
        if(!ten.matches(TEN)){
            System.out.println("nhập sai định dạng Nguyen Van A");
            return null;
        }
        else {
            result=ten;
        }
        return result;
    }
    public String inputMa() {
        System.out.printf("Số Đăng Ký : ");
        String soDangKy = scanner.nextLine();
        String result = null;

        if (!soDangKy.matches(SO_DANG_KY)) {
            System.out.println("Nhập sai cú pháp (Yx-xxxx) !");
            return null;
        } else {
            result = soDangKy;
        }

        for (GiayDangKy giayDangKy : giayDangKyList) {
            if (giayDangKy.getSoDangKy().equals(result)) {
                System.out.println("số dăng ký đã tồn tại");
                return null;
            }
        }

        return result;
    }

    public String getMaPhuongTien() {
        displayOTo();
        System.out.printf("Nhập mã phương tiện đăng kí : ");
        String maPhuongTien = scanner.nextLine();
        for (Oto o : oToList) {
            System.out.println(o.getMaPhuongTien());
            if (o.getMaPhuongTien().equals(maPhuongTien)) {
                return maPhuongTien;
            }
        }
        return null;
    }

    public String getMaPhuongTienXeTai() {
        displayXeTai();
        System.out.printf("Nhập mã phương tiện đăng kí : ");
        String maPhuongTien = scanner.nextLine();
        for (XeTai o : xeTaiList) {
            System.out.println(o.getMaPhuongTien());
            if (o.getMaPhuongTien().equals(maPhuongTien)) {
                return maPhuongTien;
            }
        }
        return null;
    }


    public void displayOTo() {
        for (Oto oto : oToList) {
            System.out.println(oto.toString());
        }
    }

    public void displayXeTai() {
        for (XeTai xeTai : xeTaiList) {
            System.out.println(xeTai.toString());
        }
    }
}
