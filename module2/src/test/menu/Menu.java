package test.menu;

import test.service.GiayDangKyService;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static GiayDangKyService giayDangKyService = new GiayDangKyService();
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------Quản lý phương tiện giao thông----------");
        displayMainMenu();
    }

    public static void displayMainMenu() throws ParseException {
        System.out.println("1. Đăng ký phương tiện");
        System.out.println("2. Xem dang sách đăng ký phương tiện");
        System.out.println("3. Huỷ đăng ký phương tiện");
        System.out.println("4. Thoát");
        int choice =0;
        boolean check=true;
        do {
            do {
                check = false;
                try {
                    System.out.println("mời chọn chức năng : ");
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("nhập sai định dạng :");
                    check = true;
                }
            } while (check);
            switch (choice) {
                case 1:
                    menuDK();
                    displayMainMenu();
                    break;
                case 2:
                    giayDangKyService.hienThi();
                    displayMainMenu();
                    break;
                case 3:
                    giayDangKyService.xoa();
                    displayMainMenu();
                    break;
                case 4:
                    System.exit(0);
            }
        }while (choice<1 ||choice>4);
    }
    public static void menuDK() throws ParseException {
        System.out.println("1.\tĐăng ký ô tô\n" +
                "2.\tĐăng ký xe tải\n" +
                "3.\tTrở về menu chính\n");
        int choice =0;
        boolean check=true;
        do {
            do {
                check = false;
                try {
                    System.out.println("mời chọn chức năng : ");
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("nhập sai định dạng :");
                    check = true;
                }
            } while (check);
            switch (choice) {
                case 1:
                    giayDangKyService.dangKyMoiOTo();
                    break;
                case 2:
                    giayDangKyService.dangKyMoiXeTai();
                    break;
                case 3:
                    displayMainMenu();
            }
        }while (choice<1 ||choice>3);

    }
}
