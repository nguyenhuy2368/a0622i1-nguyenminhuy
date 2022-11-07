package case_study.controllers;

import case_study.service.impl.CustomerServiceImpl;
import case_study.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("1.Employee Management\n" +
                "2.Customer Management\n" +
                "3.Facility Management \n" +
                "4.Booking Management\n" +
                "5.Promotion Management\n" +
                "6.Exit\n");
        System.out.print("Enter your choice: ");
        int choice;
        do {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    customerManagement();
                    break;
                case 3:
                    facilityManagement();
                    break;
                case 4:
                    bookingManagerment();
                    break;
                case 5:
                    promotionManagement();
                    break;
                case 6:
                    System.exit(6);
            }

        } while (true);
    }

    public static void employeeManagement() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        int choice;
        System.out.println("1.Display list employees\n" +
                "2.Add new employee\n" +
                "3.Edit employee\n" +
                "4.Return main menu\n");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                employeeService.display();
                break;
            case 2:
                employeeService.addNew();
                break;
            case 3:
                employeeService.edit();
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public static void customerManagement() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        int choice;
        System.out.println("1.Display list customers\n" +
                "2.Add new customer\n" +
                "3.Edit customer\n" +
                "4.Return main menu\n");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                customerService.display();
                break;
            case 2:
                customerService.addNew();
                break;
            case 3:
                customerService.edit();
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public static void facilityManagement() {
        int choice;
        System.out.println("1.Display list facility\n" +
                "2.Add new facility\n" +
                "3.Display list facility maintenance\n" +
                "4.Return main menu\n");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public static void bookingManagerment() {
        int choice;
        System.out.println("1.Add new booking\n" +
                "2.Display list booking\n" +
                "3.Create new constracts\n" +
                "4.Display list contracts\n" +
                "5.Edit contracts\n" +
                "6.Return main menu\n");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                displayMainMenu();
                break;
        }
    }

    public static void promotionManagement() {
        int choice;
        System.out.println("1.Display list customers use service\n" +
                "2.Display list customers get voucher\n" +
                "3.Return main menu\n");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                displayMainMenu();
                break;
        }
    }
}
