package ThiThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccRenSer {
    public static final String REGGEX_CCCD = "[\\d]{12}";
    public static List<AccountRenter> accountRenterList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void add() throws ParseException {
        accountRenterList.clear();
        accountRenterList = ReadWriteFile.readAcctRentter("D:\\A0622I1\\module2\\src\\ThiThu\\accountRentter.csv");
        boolean check;
        String CCCD = "";
        do {
            System.out.println("nhập CCCD :");
            CCCD = RegexData.regex(sc.nextLine(), REGGEX_CCCD, "Nhap sai thong tin Can cuoc cong dan!!!");
            check = false;
            for (AccountRenter accountRentter : accountRenterList) {
                if (CCCD.equals(accountRentter.getCccd())) {
                    System.out.println("CCCD " + CCCD + " đã tồn tại");
                    check = true;
                }
            }
        } while (check);
        System.out.println("nhập họ và tên: ");
        String hoVaTen = sc.nextLine();
        Date ngaySinh = null;
        System.out.println("Nhập ngày sinh: ");
        while (ngaySinh == null) {
            String dateAsString = sc.nextLine();
            ngaySinh = RegexData.validateDate(dateAsString);
            if (ngaySinh == null) {
                System.out.println("vui lòng nhập đúng định dạng dd/mm/YYYY: ");
            }
        }
        int choice = 0;
        do {
            System.out.println("mời nhập giới tính :");
            System.out.println("0. nam");
            System.out.println("1. nu");
            choice = Integer.parseInt(sc.nextLine());
        } while (choice != 0 && choice != 1);
        int gioitinh = choice;
        System.out.println("mời nhập diện tích lớn nhất :");
        float maxDienTich = Float.parseFloat(sc.nextLine());
        System.out.println("mời nhập diện tích nhỏ nhất :");
        float mixDienTich = Float.parseFloat(sc.nextLine());
        System.out.println("mời nhập sô tiền lớn nhất :");
        int maxGiaTien = Integer.parseInt(sc.nextLine());
        System.out.println("mời nhập số tièn lớn nhất :");
        int mainGiaTien = Integer.parseInt(sc.nextLine());
        AccountRenter accountRentter = new AccountRenter(CCCD, hoVaTen, ngaySinh, gioitinh, false, maxDienTich, mixDienTich, maxGiaTien, mainGiaTien);
        accountRenterList.add(accountRentter);
        ReadWriteFile.writeAccRentter(accountRenterList, "D:\\A0622I1\\module2\\src\\ThiThu\\accountRentter.csv");
    }

    public static void display() {
        accountRenterList.clear();
        accountRenterList = ReadWriteFile.readAcctRentter("D:\\A0622I1\\module2\\src\\ThiThu\\accountRentter.csv");
        Collections.sort(accountRenterList, new Comparator<AccountRenter>() {

            @Override
            public int compare(AccountRenter o1, AccountRenter o2) {
                if (o1.getHoTen().equals(o2.getHoTen())) {
                    return o1.getNgaySinh().compareTo(o2.getNgaySinh());
                }
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
        System.out.println("Danh sách người cho thuê:\n");
        for (int i = 0; i < 156; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-15s|%-15s|%-20s|%-16s|%-22s|%-15s|%-12s|%-16s|%-15s|\n", "CCCD", "Họ và tên", "Ngày sinh", "Giới tính", "Trạng thái giao dịch", "Diện tích nhà", "Địa chỉ", "Số người tối đa", "Giá tiền");
        for (int i = 0; i < 156; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (AccountRenter accountRentter : accountRenterList) {
            System.out.printf("|%-15s|%-15s|%-20s|%-16s|%-22s|%-15f|%-12s|%-16s|%-15s|\n", accountRentter.getCccd(), accountRentter.getHoTen(), simpleDateFormat.format(accountRentter.getNgaySinh()), accountRentter.getGioiTinh(), accountRentter.isTrangThai(), accountRentter.getMaxDienTich(), accountRentter.getMinDienTich(), accountRentter.getMinGiaTien(), accountRentter.getMinGiaTien());
        }
    }

    public static void writeFile() {
        ReadWriteFile.writeAccRentter(accountRenterList, "D:\\A0622I1\\module2\\src\\ThiThu\\accountRentter.csv");
        System.out.println("ghi file thành công");
    }

    public static void delete() {
        accountRenterList.clear();
        accountRenterList = ReadWriteFile.readAcctRentter("D:\\A0622I1\\module2\\src\\ThiThu\\accountRentter.csv");
        System.out.println("nhập CCCD :");
        boolean check;
        String CCCD = "";
        CCCD = RegexData.regex(sc.nextLine(), REGGEX_CCCD, "Input sai thong tin Can cuoc cong dan!!!");
        check = false;
        int index = 0;
        for (int i = 0; i < accountRenterList.size(); i++) {
            if (CCCD.equals(accountRenterList.get(i).getCccd())) {
                accountRenterList.remove(i);
                check = true;
            }
        }
        if (check) {
            ReadWriteFile.writeAccRentter(accountRenterList, "D:\\A0622I1\\module2\\src\\ThiThu\\accountRentter.csv");
            System.out.println("xóa thành công");
        } else {
            System.out.println("CCCD ko tồn tại");
        }

    }
}
