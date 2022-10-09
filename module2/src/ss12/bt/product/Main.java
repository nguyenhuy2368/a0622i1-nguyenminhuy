package ss12.bt.product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        Product product;
        int id = 0, price, choice;
        String name;
        do {
            System.out.println("1.Thêm sản phẩm \t2.Sửa sp \t3.Xoá sp \t4.Hiển thị");
            System.out.println("5.Tìm sp theo tên \t6.Sắp xếp theo giá tăng dần \t7.Sắp xếp theo giá giảm dần");
            System.out.println("0.Thoát");
            System.out.println("Nhập lựa chọn của ban:  ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("nhap id ");
                    id = scanner.nextInt();
                    System.out.print("Nhập tên của sp ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.print("Nhap gia san pham: ");
                    price = scanner.nextInt();
                    product = new Product(id, name, price);
                    productManager.addProduct(product);
                    break;
                case 2:
                    System.out.print("nhap id sp muon sua 1");
                    id=scanner.nextInt();
                    System.out.print("Nhap ten moi: ");
                    scanner.nextLine();
                    name=scanner.nextLine();
                    System.out.print("Nhap gia moi: ");
                    price=scanner.nextInt();
                    product=new Product(id,name,price);
                    productManager.editProduct(id,product);
                    break;
                case 3:
                    System.out.println("nhap id sp muon xoa");
                    id=scanner.nextInt();
                    productManager.deleteProduct(id);
                    break;
                case 4:
                    productManager.displayProduct();
                    break;
                case 5:
                    System.out.print("Nhap ten sp muon tim");
                    scanner.nextLine();
                    name=scanner.nextLine();
                    productManager.searchProduct(name);
                    break;
                case 6:
                    System.out.println("cac sp sap xep theo gia tang dan");
                    productManager.sortPriceAscending();
                    break;
                case 7:
                    System.out.println("cac sp sap xep theo gia giam dan");
                    productManager.sortPriceDecrease();
                case 0:
                    System.exit(0);
            }
        } while (true);

    }
}
