package ThiThu;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    public static AccountLessorService accountLessorService = new AccountLessorService();
    public static AccRenSer accRenSer = new AccRenSer();

    public static void main(String[] args) throws Exception {
        displayMenu();
    }

    public static void displayMenu() throws Exception {
        int choice = 0;
        System.out.println("1. Chức năng đăng ký người thuê/cho thuê nhà\n" +
                "2. Hiển thị thông tin người thuê/cho thuê nhà\n" +
                "3. Tìm kiếm người cho thuê phù hợp theo CCCD của người thuê\n" +
                "4. Hiển thị và xoá những người thuê/cho thuê nhà thành công\n" +
                "5. Lưu lại dữ liệu người thuê/cho thuê vào file\n" +
                "6. Import dữ liệu người thuê/cho thuê vào chương trình\n" +
                "7. Thoát\n");
        System.out.println("Nhập lựa chọn của bạn");
        do {
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai định dạng");
            }
            switch (choice) {
                case 1:
                    displayDangKy();
                    displayMenu();
                    break;
                case 2:
                    hienThi();
                    displayMenu();
                    break;
                case 3:
                    timKiem();
                    displayMenu();
                    break;
                case 4:
                    xoa();
                    displayMenu();
                    break;
                case 5:
                    ghiFile();
                    displayMenu();
                    break;
                case 6:
                    hienThi();
                    displayMenu();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("vui longf chọn 1-7");
            }

        }while (choice<1 ||choice>7);
    }

    public static void displayDangKy() throws Exception {
        System.out.println("Menu Đăng ky");
        System.out.println("1.Dăng ký người cho thuê");
        System.out.println("2.Dăng ký người thuê");
        System.out.println("3.Về menu chính");
        int choice=0;
        do {
            try {
                System.out.println("Mời chọn chức năng");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai định dạng");
            }
            switch (choice){
                case 1:
                    accountLessorService.add();
                    displayDangKy();
                    break;
                case 2:
                    accRenSer.add();
                    displayDangKy();
                    break;
                case 3:
                    displayMenu();
                    break;
                default:
                    System.out.println("vui lòng chọn 1 hoặc 2 hoăc 3");
            }
        }while (choice<1 && choice>3);
    }
    public static void hienThi() throws Exception {
        System.out.println("Menu hiển thị");
        System.out.println("1.Hiển thị danh sách người cho thuê");
        System.out.println("2.Hiển thị danh sách người thuê");
        System.out.println("3.Về menu chính");
        int choice=0;
        do {
            try {
                System.out.println("Mời chọn chức năng");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai định dạng");
            }
            switch (choice){
                case 1:
                    accountLessorService.display();
                    hienThi();
                    break;
                case 2:
                    accRenSer.display();
                    hienThi();
                    break;
                case 3:
                    displayMenu();
                    break;
                default:
                    System.out.println("vui lòng chọn 1 hoặc 2");
            }
        }while (choice<1&&choice>3);
    }
    public static void timKiem(){
        accountLessorService.timkiem();
    }
    public static void xoa() throws Exception {
        accountLessorService.delete();
        displayMenu();
    }
    public static void ghiFile() throws Exception {
        System.out.println("Menu ghi file");
        System.out.println("1.Ghi file accountLessor");
        System.out.println("2.Ghi file accountRentter");
        System.out.println("3.Về menu chính");
        int choice=0;
        do {
            try {
                System.out.println("Mời chọn chức năng");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai định dạng");
            }
            switch (choice){
                case 1:
                    accountLessorService.writeFile();
                    ghiFile();
                    break;
                case 2:
                    accRenSer.writeFile();
                    ghiFile();
                    break;
                case 3:
                    displayMenu();
                    break;
                default:
                    System.out.println("vui lòng chọn 1 hoặc 2");
            }
        }while (choice<1 && choice>3);
    }
}
