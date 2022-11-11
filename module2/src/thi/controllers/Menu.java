package thi.controllers;

import thi.models.BrandMobile;
import thi.models.SecondMobile;
import thi.utils.FileUtils;

import java.util.Scanner;


public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static BrandMobile brandMobile = new BrandMobile();
    public static SecondMobile secondMobile = new SecondMobile();

    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu(){
        int choice = 0;
        System.out.println("-----CHUONG TRINH QUAN LY DIEN THOAI-----");
        System.out.println("1. Them moi");
        System.out.println("2. Xoa");
        System.out.println("3. Xem danh sach dien thoai");
        System.out.println("4. Tim kiem");
        System.out.println("5. Thoat");
        System.out.print("Nhap lua chon cua ban: ");
        do {
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    themMoi();
                    displayMenu();
                    break;
                case 2:
                    xoa();
                    displayMenu();
                    break;
                case 3:
                    xemDanhSach();
                    displayMenu();
                    break;
                case 4:
                    timKiem();
                    displayMenu();
                    break;
                case 5:
                    timKiem();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chon tu 1-5!");
            }

        }while (choice<1 ||choice>5);
    }
    public static void themMoi() {
        String name, brand, rangeGuarante,fromNation,status;
        int id = 0, price, quantity, timeGuarantee;
        System.out.println("---Them moi dien thoai---");
        System.out.println("1. Them moi dien thoai chinh hang");
        System.out.println("2. Them moi dien thoai xach tay");
        System.out.println("3. Tro ve menu chinh");
        System.out.print("Chon chuc nang: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            id = FileUtils.getIdLastBrandMobile() + 1;
        } else if (choice == 2) {
            id = FileUtils.getIdLastSecondMobile() + 1;
        }
        if ((choice == 1) || (choice == 2)) {
            System.out.print("Nhap ten dien thoai: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Nhap gia dien thoai:");
            price = sc.nextInt();
            System.out.print("Nhap so luong: ");
            quantity = sc.nextInt();
            System.out.print("Nhap hang: ");
            sc.nextLine();
            brand = sc.nextLine();
            if (choice == 1) {
                System.out.print("Nhap thoi gian bao hanh: ");
                timeGuarantee = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap pham vi bao hanh: ");
                sc.nextLine();
                rangeGuarante = sc.nextLine();
                brandMobile = new BrandMobile(id, name, price, quantity, brand, timeGuarantee, rangeGuarante);
                FileUtils.writeBrandMobile(brandMobile);
            } else {
                System.out.print("Nhap quoc gia xach tay: ");
                fromNation = sc.nextLine();
                System.out.print("Nhap trang thai: ");
                status = sc.nextLine();
                secondMobile = new SecondMobile(id, name, price, quantity, brand, fromNation, status);
                FileUtils.writeSecondMobile(secondMobile);
            }
        } else if (choice == 3) {
            displayMenu();
        }
    }
    public static void xoa(){
        System.out.println("---Xoa dien thoai---");
        System.out.println("1. Xoa dien thoai chinh hang theo id");
        System.out.println("2. Xoa dien thoai xach tay theo id");
        System.out.println("3. Tro ve menu chinh");
        System.out.print("Chon chuc nang: ");
        int choice = sc.nextInt();
        int idDelete;
        switch (choice){
            case 1:
                FileUtils.readBrandMobile();
                System.out.print("Nhap vao id can xoa: ");
                idDelete = sc.nextInt();
                FileUtils.deleteBrandMobile(idDelete);
                FileUtils.readBrandMobile();
                break;
            case 2:
                FileUtils.readSecondMobile();
                System.out.print("Nhap vao id can xoa: ");
                idDelete = sc.nextInt();
                FileUtils.deleteSecondMobile(idDelete);
                FileUtils.readSecondMobile();
                break;
            case 3:
                displayMenu();
                break;
        }
    }
    public static void xemDanhSach(){
        System.out.println("---Hien thi danh sach dien thoai---");
        System.out.println("1. Xem danh sach dien thoai chinh hang");
        System.out.println("2. Xem danh sach dien thoai xach tay");
        System.out.println("3. Tro ve menu chinh");
        System.out.print("Chon chuc nang: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                FileUtils.readBrandMobile();
                break;
            case 2:
                FileUtils.readSecondMobile();
                break;
            case 3:
                displayMenu();
                break;
        }
    }
    public static void timKiem(){
        String nameFound;
        System.out.println("---Tim kiem dien thoai theo ten---");
        System.out.println("1. Tim kiem dien thoai chinh hang theo ten");
        System.out.println("2. Tim kiem dien thoai xach tay theo ten");
        System.out.println("3. Tro ve menu chinh");
        System.out.print("Chon chuc nang: ");
        int choice =sc.nextInt();
        switch (choice){
            case 1:
                System.out.print("Nhap ten dien thoai muon tim: ");
                sc.nextLine();
                nameFound = sc.nextLine();
                FileUtils.searchNameBrandMobile(nameFound);
                break;
            case 2:
                System.out.print("Nhap ten dien thoai muon tim: ");
                sc.nextLine();
                nameFound = sc.nextLine();
                FileUtils.searchNameSecondMobile(nameFound);

        }
    }
}
