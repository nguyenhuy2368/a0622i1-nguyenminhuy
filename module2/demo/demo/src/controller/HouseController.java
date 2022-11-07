package controller;

import service.Controller;

import java.util.Scanner;


// SPxxxx x la so
// SP0001
// SP0002
public class HouseController {
    public static void main(String[] args) {
        displayMainMenu();
    }


    public static void displayMainMenu() {
        Controller controller = new Controller();
        boolean check = true;

        while (check) {
            System.out.println("------HOUSE MANAGEMENT SYSTEM------");
            System.out.println("1. Register ");
            System.out.println("2. Show information");
            System.out.println("3. Search ");
            System.out.println("4. delete and display: ");
            System.out.println("5. save account information in file.");
            System.out.println("6. Import information from file to program ");
            System.out.println("7. exit ");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("you entered the wrong format, please type again from 1 to 7 :");
            }
            switch (choice) {
                case 1:
                    displayRegisterMenu();
                    break;
                case 2:
                    controller.display();
                    break;
                case 3:

                    break;
                case 4:
                    controller.deleteRenterAccount();
                    break;
                case 5:
                    displaySaveToFileMenu();
                    System.out.println("ghi thành công!");
                    break;
                case 6:
                    displayReadFromFileMenu();
                    System.out.println("Đọc thành công!");
                    break;
                case 7:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                    check = false;
                    break;
            }
        }
    }

    public static void displayRegisterMenu() {
        Controller controller = new Controller();
        boolean check = true;
        while (check) {
            System.out.println("------Register menu------");
            System.out.println("1. add new account renter ");
            System.out.println("2. add new account lessor ");
            System.out.println("3. Back to main menu");
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("you entered the wrong format, please type again from 1 to 7 :");
            }
            switch (choice) {
                case 1:
                    controller.addNewRenter();
                    break;
                case 2:
                    controller.addNewLessor();
                    break;
                case 3:
                    check = false;
                    break;
            }
        }
    }

    public static void displaySaveToFileMenu() {
        Controller controller = new Controller();
        boolean check = true;
        while (check) {
            System.out.println("------Register menu------");
            System.out.println("1. write account renter ");
            System.out.println("2. write account lessor ");
            System.out.println("3. Back to main menu");
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("you entered the wrong format, please type again from 1 to 3 :");
            }
            switch (choice) {
                case 1:
                    controller.addRenterToFile();
                    break;
                case 2:
                    controller.addLessorToFile();
                    break;
                case 3:
                    check = false;
                    break;
            }
        }
    }

    public static void displayReadFromFileMenu() {
        Controller controller = new Controller();
        boolean check = true;
        while (check) {
            System.out.println("------Register menu------");
            System.out.println("1. write account renter ");
            System.out.println("2. write account lessor ");
            System.out.println("3. Back to main menu");
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("you entered the wrong format, please type again from 1 to 3 :");
            }
            switch (choice) {
                case 1:
                    controller.readRenterFrmFile();
                    break;
                case 2:
                    controller.readLessorFromFile();
                    break;
                case 3:
                    check = false;
                    break;
            }
        }
    }
}

