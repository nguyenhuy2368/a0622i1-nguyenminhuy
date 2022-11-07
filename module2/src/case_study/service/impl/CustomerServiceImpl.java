package case_study.service.impl;

import case_study.models.person.Customer;
import case_study.service.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList =new LinkedList<>();
    private Scanner sc = new Scanner(System.in);
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
        System.out.println("Input customer id:");
        String customerId = sc.nextLine();
        int choice = 0;
        String customerType = "";
        do {
            System.out.println("Input customer type:\n" +
                    "1.\tDiamond\n" +
                    "2.\tPlatinium\n" +
                    "3.\tGold\n" +
                    "4.\tSilver\n" +
                    "5.\tMember\n");
            System.out.println("Please input your choice");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
            }
            switch (choice) {
                case 1:
                    customerType = "Diamond";
                    break;
                case 2:
                    customerType = "Platinium";
                    break;
                case 3:
                    customerType = "Gold";
                    break;
                case 4:
                    customerType = "Silver";
                    break;
                case 5:
                    customerType = "Member";
                    break;
                default:
                    System.out.println("Please input from 1 to 5");
            }
        } while (choice < 1 || choice > 5);
        System.out.println("Input address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(name,birthDay,gender,cmnd,phone,email,customerId,customerType,address);
        customerList.add(customer);
        System.out.println("Add new customer successfull");


    }

    @Override
    public void display() {
        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void edit() {
        System.out.println("Input customer id edit:");
        String idEdit = sc.nextLine();
        int index = 0;
        boolean temp = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (idEdit.equals(customerList.get(i).getCustomerId())) {
                temp = true;
                index = i;
            }
        }
        if (temp){
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
            System.out.println("Input customer id:");
            String customerId = sc.nextLine();
            int choice = 0;
            String customerType = "";
            do {
                System.out.println("Input customer type:\n" +
                        "1.\tDiamond\n" +
                        "2.\tPlatinium\n" +
                        "3.\tGold\n" +
                        "4.\tSilver\n" +
                        "5.\tMember\n");
                System.out.println("Please input your choice");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please input again!");
                }
                switch (choice) {
                    case 1:
                        customerType = "Diamond";
                        break;
                    case 2:
                        customerType = "Platinium";
                        break;
                    case 3:
                        customerType = "Gold";
                        break;
                    case 4:
                        customerType = "Silver";
                        break;
                    case 5:
                        customerType = "Member";
                        break;
                    default:
                        System.out.println("Please input from 1 to 5");
                }
            } while (choice < 1 || choice > 5);
            System.out.println("Input address: ");
            String address = sc.nextLine();
            Customer customer = new Customer(name,birthDay,gender,cmnd,phone,email,customerId,customerType,address);


        }
    }
}
