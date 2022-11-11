package testabc.controllers;

import testabc.service.PhuongTienService;

import java.util.Scanner;



public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------Quản lý phương tiện giao thông----------");
        displayMainMenu(scanner);
    }

    public static void displayMainMenu(Scanner scanner) {
        System.out.println("1. Đăng ký phương tiện");
        System.out.println("2. Xem dang sách đăng ký phương tiện");
        System.out.println("3. Huỷ đăng ký phương tiện");
        System.out.println("4. Thoát");
        getMainMenu(scanner);
    }

    public static void getMainMenu(Scanner scanner) {
        PhuongTienService phuongTienService = new PhuongTienService();
        System.out.printf("Nhập lựa chọn : ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                phuongTienService.dangKy();
                displayMainMenu(scanner);
                break;
            case 2:
                phuongTienService.display();
                displayMainMenu(scanner);
                System.out.print("tt");
                break;
            case 3:
                phuongTienService.delete();
                displayMainMenu(scanner);
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Choice again !");
                displayMainMenu(scanner);
                break;

        }
    }
}
