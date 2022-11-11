package ThiThu;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.text.SimpleDateFormat;
import java.util.*;

public class AccountLessorService {
    public static final String REGEX_CCCD = "[\\d]{12}";
    public static List<AccountLessor> accountLessorList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static void add() throws Exception{
        accountLessorList.clear();
        accountLessorList = ReadWriteFile.readAccLessor("D:\\A0622I1\\module2\\src\\ThiThu\\accLes.csv");
        boolean check;
        String CCCD="";
        do {
            System.out.println("Nhap CCCD :");
            CCCD= RegexData.regex(sc.nextLine(),REGEX_CCCD,"Nhap sai thong tin Can cuoc cong dan!!!");
            check=false;
            for (AccountLessor accountLessor : accountLessorList) {
                if (CCCD.equals(accountLessor.getCccd())) {
                    System.out.println("CCCD " + CCCD + " da ton tai");
                    check=true;
                }
            }
        }while (check);
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
        int choice=0;
        do {
            System.out.println("mời nhập giới tính :");
            System.out.println("0. nam");
            System.out.println("1. nu");
            choice = Integer.parseInt(sc.nextLine());
        }while (choice!=0&&choice!=1);
        int gioitinh = choice;
        System.out.println("mời nhập diện tích :");
        float dienTich = Float.parseFloat(sc.nextLine());
        System.out.println("nhập địa chỉ :");
        String diaChi = sc.nextLine();
        System.out.println("nhập số người ở :");
        int soNguoi = Integer.parseInt(sc.nextLine());
        System.out.println("giá tiền :");
        int giaTien = Integer.parseInt(sc.nextLine());
        AccountLessor accountLessor = new AccountLessor(CCCD,hoVaTen,ngaySinh,gioitinh,false,dienTich,diaChi,soNguoi,giaTien);
        accountLessorList.add(accountLessor);
        ReadWriteFile.writeAccLessor(accountLessorList,"D:\\A0622I1\\module2\\src\\ThiThu\\accLes.csv");
    }
    public static void writeFile(){
        ReadWriteFile.writeAccLessor(accountLessorList,"D:\\A0622I1\\module2\\src\\ThiThu\\accLes.csv");
    }
    public static void display(){
        accountLessorList.clear();
        accountLessorList = ReadWriteFile.readAccLessor("D:\\A0622I1\\module2\\src\\ThiThu\\accLes.csv");
        Collections.sort(accountLessorList, new Comparator<AccountLessor>() {
            @Override
            public int compare(AccountLessor o1, AccountLessor o2) {
                if(o1.getHoTen().equals(o2.getHoTen())){
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
        for(AccountLessor accountLessor:accountLessorList){
            System.out.printf("|%-15s|%-15s|%-20s|%-16s|%-22s|%-15f|%-12s|%-16s|%-15s|\n", accountLessor.getCccd(), accountLessor.getHoTen(), simpleDateFormat.format(accountLessor.getNgaySinh()), accountLessor.getGioiTinh(), accountLessor.isTrangThai(), accountLessor.getDienTich(), accountLessor.getDiaChi(), accountLessor.getSoNguoi(), accountLessor.getGiaTien());
        }
    }
    public static void timkiem(){
        accountLessorList.clear();
        accountLessorList = ReadWriteFile.readAccLessor("D:\\A0622I1\\module2\\src\\ThiThu\\accLes.csv");
        System.out.println("nhập CCCD :");
        boolean check;
        String CCCD="";
        CCCD= RegexData.regex(sc.nextLine(),REGEX_CCCD,"Input sai thong tin Can cuoc cong dan!!!");
        while (!accountLessorList.contains(CCCD)){
            System.out.println("CCCD này chưa tồn tại");
            System.out.println("mời nhập lại :");
            CCCD= RegexData.regex(sc.nextLine(),REGEX_CCCD,"Input sai thong tin Can cuoc cong dan!!!");
        }

    }
    public static void delete(){
        accountLessorList.clear();
        accountLessorList =  ReadWriteFile.readAccLessor("D:\\A0622I1\\module2\\src\\ThiThu\\accLes.csv");
        System.out.println("nhập CCCD :");
        boolean check;
        String CCCD="";
        CCCD= RegexData.regex(sc.nextLine(),REGEX_CCCD,"Input sai thong tin Can cuoc cong dan!!!");
        check=false;
        int index=0;
        for (int i=0;i<accountLessorList.size();i++) {
            if (CCCD.equals(accountLessorList.get(i).getCccd())) {
                accountLessorList.remove(i);
                check=true;
            }
        }
        if(check){

            for(AccountLessor accountLessor:accountLessorList){
                System.out.println(accountLessor.getInfor());
            }
            ReadWriteFile.writeAccLessor(accountLessorList,"D:\\A0622I1\\module2\\src\\ThiThu\\accLes.csv");
            System.out.println("xóa thành công");
        }else {
            System.out.println("CCCD ko tồn tại");
        }

    }
}
