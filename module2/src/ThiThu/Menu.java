package ThiThu;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<AccountLessor> lessorList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {  displayMenu();  }
    public static void displayMenu(){
        int choice;
        System.out.println("1. Chức năng đăng ký người thuê/cho thuê nhà\n" +
                "2. Hiển thị thông tin người thuê/cho thuê nhà\n" +
                "3. Tìm kiếm người cho thuê phù hợp theo CCCD của người thuê\n" +
                "4. Hiển thị và xoá những người thuê/cho thuê nhà thành công\n" +
                "5. Lưu lại dữ liệu người thuê/cho thuê vào file\n" +
                "6. Import dữ liệu người thuê/cho thuê vào chương trình\n" +
                "7. Thoát\n");
        System.out.println("Nhập lựa chọn của bạn");
        do {
            choice =sc.nextInt();
            switch (choice){
                case 1:
                    addNewAccLessor();
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
                    break;
                case 7:
                    break;
            }

        }while (true);

    }
    public static void addNewAccLessor(){
        System.out.println("Nhập cccd");
        String cccd = sc.nextLine();
        System.out.println("Nhập họ và tên");
        String hoVaTen = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        Date ngaySinh = new Date(sc.nextLine());
        System.out.println("Nhập giới tính");
        int gioiTinh;
        do {
            System.out.println("Nhập giới tính");
            gioiTinh = Integer.parseInt(sc.nextLine());
        }while (gioiTinh<-1 || gioiTinh >0);
        String gioTinh ="";
        switch (gioiTinh){
            case 1 :
                gioTinh = "Nam";
                break;
            case 0:
                gioTinh = "Nữ";
                break;
        }
        System.out.println("nhập diện tích");
        float dienTich = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập địa chỉ");
        String diaChi = sc.nextLine();
        System.out.println("nhập số người ở tối đa");
        int soNguoi = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập giá tiền");
        int giaTien=Integer.parseInt(sc.nextLine());
        AccountLessor accountLessor = new AccountLessor(cccd,hoVaTen,ngaySinh,gioiTinh,false,dienTich,diaChi,soNguoi,giaTien  );
        lessorList.add(accountLessor);
    }
    public static void addNewAccRenter(){
        System.out.println("nhập cccd");
        String cccd = sc.nextLine();
        System.out.println("Nhập họ và tên");
        String hoVaTen = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        Date ngaySinh = new Date(sc.nextLine());
        System.out.println("Nhập giới tính");
        int gioiTinh;
        do {
            System.out.println("Nhập giới tính");
            gioiTinh = Integer.parseInt(sc.nextLine());
        }while (gioiTinh<-1 || gioiTinh >0);
        String gioTinh ="";
        switch (gioiTinh){
            case 1 :
                gioTinh = "Nam";
                break;
            case 0:
                gioTinh = "Nữ";
                break;
        }
        System.out.println("nhập diện tích nhỏ nhất cần thuê");
        float minDienTich = Float.parseFloat(sc.nextLine());
        System.out.println("nhập diện tích lớn nhất cần thuê");
        float maxDienTich = Float.parseFloat(sc.nextLine());
        
    }
}
