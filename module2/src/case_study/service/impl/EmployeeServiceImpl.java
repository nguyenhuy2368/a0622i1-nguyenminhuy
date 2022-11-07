package case_study.service.impl;

import case_study.models.person.Employee;
import case_study.service.EmployeeService;
import ss16_io.th.tim_max_ghi_file.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addNew() {
        System.out.println("Input name :");
        String name = sc.nextLine();
        System.out.println("In put birthday:");
        String birthDay = sc.nextLine();
        System.out.println("Input gender:");
        String gender = sc.nextLine();
        System.out.println("Input CMND:");
        String cmnd = sc.nextLine();
        System.out.println("Input phone:");
        String phone = sc.nextLine();
        System.out.println("Input email :");
        String email = sc.nextLine();
        System.out.println("Input employee id:");
        String employeeId = sc.nextLine();
        int choice = 0;
        String degree = "";
        do {
            System.out.println("Input degree:\n" +
                    "1.\tTrung cấp\n" +
                    "2.\tCao đẳng\n" +
                    "3.\tĐại học\n" +
                    "4.\tSau đại học\n");
            System.out.println("Please input your choice");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
            }
            switch (choice) {
                case 1:
                    degree = "Trung cấp";
                    break;
                case 2:
                    degree = "Cao đẳng";
                    break;
                case 3:
                    degree = "Đại học";
                    break;
                case 4:
                    degree = "Sau đại học";
                    break;
                default:
                    System.out.println("Please input from 1 to 4");
            }
        } while (choice < 1 || choice > 4);

        String position = "";
        do {
            System.out.println("Nhập vị trí:\n" +
                    "1.\tLễ tân\n" +
                    "2.\tPhục vụ\n" +
                    "3.\tChuyên Viên\n" +
                    "4.\tGiám sát\n" +
                    "5.\tQuản lý\n" +
                    "6.\tGiám đóc\n");
            System.out.println("Please input your choice:");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
            }
            switch (choice) {
                case 1:
                    position = "Lễ tân";
                    break;
                case 2:
                    position = "Phục vụ";
                    break;
                case 3:
                    position = "Chuyên Viên";
                    break;
                case 4:
                    position = "Giám sát";
                    break;
                case 5:
                    position = "Quản lý";
                    break;
                case 6:
                    position = "Giám đốc";
                    break;
                default:
                    System.out.println("Please input from 1 to 6");
            }
        }
        while (choice < 1 || choice > 6);
        System.out.println("Input salary :");
        int salary = sc.nextInt();
        System.out.println("Add new employee successfull");
        Employee employee = new Employee(name, birthDay, gender,cmnd,phone,email,employeeId,degree,position,salary);
        employeeList.add(employee);

    }

    @Override
    public void display() {
        if (employeeList.size() > 0) {
            System.out.println("List Employee");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-28s%-12s%-12s%-15s%-12s%-12s%-12s%-18s%-12s%-15s%-12s%-12s", "", "|     Id",
                    "|    name", "|   birth day", "|   gender", "| cmnd",
                    "|   phone", "|     email", "| degree", "| position", "|   salary", "|");
            for (Employee em : employeeList) {
                System.out.printf("%-28s%-12s%-12s%-15s%-12s%-12s%-12s%-18s%-12s%-15s%-12s%-12s", " ",
                        "| " + "| " + em.getName(), "| " + em.getBirthDay(), "| " + em.getGender(), "| " + em.getCmnd(),
                        "| " + em.getPhone(), "| " + em.getEmail(), "| " + em.getDegree(), "| " + em.getPosition(), "| " + em.getSalary(), "|");
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
            }
            System.out.println();
        } else {
            System.out.println(" not exist data");
        }
    }


    @Override
    public void edit() {
        System.out.println("Input name employee edit:");
        String nameEdit = sc.nextLine();
        int index = 0;
        boolean temp = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (nameEdit.equals(employeeList.get(i).getName())) {
                temp = true;
                index = i;
            }
        }
        if (temp) {
            System.out.println("Input name :");
            String name = sc.nextLine();
            System.out.println("In put birthday:");
            String birthDay = sc.nextLine();
            System.out.println("Input gender:");
            String gender = sc.nextLine();
            System.out.println("Input CMND:");
            String cmnd = sc.nextLine();
            System.out.println("Input phone:");
            String phone = sc.nextLine();
            System.out.println("Input email :");
            String email = sc.nextLine();
            System.out.println("Input employee id:");
            String employeeId = sc.nextLine();
            int choice = 0;
            String degree = "";
            do {
                System.out.println("Input degree:\n" +
                        "1.\tTrung cấp\n" +
                        "2.\tCao đẳng\n" +
                        "3.\tĐại học\n" +
                        "4.\tSau đại học\n");
                System.out.println("Please input your choice:");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please input again!");
                }
                switch (choice) {
                    case 1:
                        degree = "Trung cấp";
                        break;
                    case 2:
                        degree = "Cao đẳng";
                        break;
                    case 3:
                        degree = "Đại học";
                        break;
                    case 4:
                        degree = "Sau đại học";
                        break;
                    default:
                        System.out.println("Please input from 1 to 4");
                }
            } while (choice < 1 || choice > 4);

            String position = "";
            do {
                System.out.println("Nhập vị trí:\n" +
                        "1.\tLễ tân\n" +
                        "2.\tPhục vụ\n" +
                        "3.\tChuyên Viên\n" +
                        "4.\tGiám sát\n" +
                        "5.\tQuản lý\n" +
                        "6.\tGiám đóc\n");
                System.out.println("Please input your choice:");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please input again!");
                }
                switch (choice) {
                    case 1:
                        position = "Lễ tân";
                        break;
                    case 2:
                        position = "Phục vụ";
                        break;
                    case 3:
                        position = "Chuyên Viên";
                        break;
                    case 4:
                        position = "Giám sát";
                        break;
                    case 5:
                        position = "Quản lý";
                        break;
                    case 6:
                        position = "Giám đốc";
                        break;
                    default:
                        System.out.println("Please input from 1 to 6");
                }
            }
            while (choice < 1 || choice > 6);
            System.out.println("Input salary :");
            int salary = sc.nextInt();
            Employee employee = new Employee(name, birthDay, gender,cmnd,phone,email,employeeId,degree,position,salary);



        } else {
            System.out.println("Employee not found");
        }
    }
}
