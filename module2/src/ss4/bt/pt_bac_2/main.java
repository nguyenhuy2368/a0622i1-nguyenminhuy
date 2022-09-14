package ss4.bt.pt_bac_2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ax^2+bx+c=0 ");
        System.out.println("Nhap vao cac tham so a, : ");
        double a = scanner.nextDouble();
        System.out.println("Nhap vao cac tham so b : ");
        double b = scanner.nextDouble();
        System.out.println("Nhap vao cac tham so c : ");
        double c = scanner.nextDouble();

        QuadraticEquation ptb2 = new QuadraticEquation(a,b,c);
        if (ptb2.getDiscriminant()<0){
            System.out.println("pt vo ngiệm");
        }else if (ptb2.getDiscriminant()==0){
            System.out.println("pt co 1 nghiem kep: "+ ptb2.getRoot1());
        } else {
            System.out.println("pt co 2 nghiem: ");
            System.out.println("no 1: "+ ptb2.getRoot1());
            System.out.println("no 2: "+ ptb2.getRoot2());
        }

    }
}
