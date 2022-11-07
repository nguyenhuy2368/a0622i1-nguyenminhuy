package service;

import exception.AccountInvalidException;
import utils.RegexData;
import model.Account;
import model.AccountLessor;
import model.AccountRenter;
import utils.ReadAndWrite;
import utils.Validate;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static List<Account> accountList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    final static String REGEX_CCCD = "^([0-9]{12})$";
    final static String REGEX_BIRTHDAY = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";


    public void display() {
        for (Account account : accountList) {
            System.out.println(account.toString());
        }
    }

    public void addNewRenter() {
        String idCard = inputCccd();
        while (checkExistCccd(idCard)) {
            System.out.println("CCCD đã trùng vui lòng nhập lại");
            idCard = scanner.nextLine();
        }
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
//        System.out.println("vui lòng nhập đúng định dạng dd/mm/YYYY: ");
//        String birthday = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
//        String dateAsString = scanner.nextLine();
        Date birthday = null;
        while (birthday == null) {
            System.out.println("Nhập ngày sinh: ");
            String dateAsString = scanner.nextLine();
            try {
                birthday = Validate.validateDate(dateAsString);
            } catch (AccountInvalidException e) {
                System.out.println(e.getMessage());
            }

            if (birthday == null) {
                System.out.println("vui lòng nhập đúng định dạng dd/mm/YYYY: ");
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(birthday);

        System.out.println("Nhập giới tính");
        int gender = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập diện tích nhỏ nhất bạn muốn thuê ");
        float minArea = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập diện tích lớn nhất bạn muốn thuê ");
        float maxArea = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số tiền nhỏ nhất bạn muốn thuê ");
        int minPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số tiền lớn nhất bạn muốn thuê ");
        int maxPrice = Integer.parseInt(scanner.nextLine());
        AccountRenter accountRenter = new AccountRenter(idCard, name, birthday, gender, false, minArea, maxArea, minPrice, maxPrice);
        accountList.add(accountRenter);
    }


    public void addNewLessor() {
        String idCard = inputCccd();
        while (checkExistCccd(idCard)) {
            System.out.println("CCCD đã trùng vui lòng nhập lại");
            idCard = scanner.nextLine();
        }
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        System.out.println("vui lòng nhập đúng định dạng dd/mm/YYYY: ");
        String birthday = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
        System.out.println("Nhập giới tính");
        int gender = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập diện tích nhà bạn cho thuê ");
        float area = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập địa chỉ ");
        String address = scanner.nextLine();
        System.out.println("Nhập số người ở tối đa ");
        int peopleMax = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá ");
        int price = Integer.parseInt(scanner.nextLine());
        AccountLessor accountLessor = new AccountLessor(idCard, name, birthday, gender, false, area, address, peopleMax, price);
        accountList.add(accountLessor);
    }

    public void addLessorToFile() {
        ReadAndWrite.writeFileAccount(accountList, "D:\\Codegym\\module2\\src\\test_module2\\data\\AccountLessor.csv");
    }

    public void addRenterToFile() {
        ReadAndWrite.writeFileAccount(accountList, "D:\\Codegym\\module2\\src\\test_module2\\data\\AccountRenter.csv");
    }

    public void readLessorFromFile() {
        accountList = ReadAndWrite.readFileAccount("D:\\Codegym\\module2\\src\\test_module2\\data\\AccountLessor.csv");
    }

    public void readRenterFrmFile() {
        accountList = ReadAndWrite.readFileAccount("D:\\Codegym\\module2\\src\\test_module2\\data\\AccountRenter.csv");
    }

    public void deleteRenterAccount() {
        System.out.println("nhập CCCD account bạn muốn xóa: ");
        Integer checkId = scanner.nextInt();
        boolean flag = false;
        for (Account account : accountList
        ) {
            if (checkId.equals(account.getIdCard())) {
                System.out.println("Bạn có muốn account có mã IDCard là: " + checkId + " không?");
                System.out.println("1: Có.");
                System.out.println("2: Không.");
                int checkDel = scanner.nextInt();
                switch (checkDel) {
                    case 1:
                        accountList.remove(account);
                        System.out.println("Đã xóa thành công");
                        break;
                    case 2:
                        System.out.println("Không xóa");
                        break;
                }
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tồn tại account có mã IDcard là : " + checkId);
        }
        display();
    }

    //validate cccd
    public String inputCccd() {
        System.out.println("Nhập CCCD: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_CCCD, "CCCD không đúng định dạng!, vui lòng nhập lại");
    }

    //check trùng cccd
    public boolean checkExistCccd(String input) {
        for (Account acc : accountList) {
            if (input.equals(acc.getIdCard())) {
                return true;
            }
        }
        return false;
    }
}
