package _3_array.bt;
import java.util.Scanner;
public class GopMang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Nhap kich thuoc mang 1
        System.out.print("Nhap kich thuoc mang thu nhat: ");
        int dodai1=scanner.nextInt();
        int []arr1=new int[dodai1];
        int index1=0;
        while (index1<dodai1){
            System.out.print("Nhap phan tu thu"+(index1+1)+": ");
            arr1[index1]=scanner.nextInt();
            index1++;
        }
        //Nhap kich thuoc mang 2
        System.out.print("Nhap kich thuoc mang thu hai: ");
        int dodai2=scanner.nextInt();
        int []arr2=new int[dodai2];
        int index2=0;
        while (index2<dodai2){
            System.out.print("Nhap phan tu thu"+(index2+1)+": ");
            arr2[index2]=scanner.nextInt();
            index2++;
        }
        //Xuat mang 1
        System.out.print("Mang thu nhat: ");
        for (int element1:arr1){
            System.out.print(element1+" ");
        }
        //Xuat mang 2
        System.out.println();
        System.out.print("Mang thu hai: ");
        for (int element2:arr2){
            System.out.print(element2+" ");
        }
        //Gop 2 mang
        int dodai3=dodai1+dodai2;
        int [] arr3=new int[dodai3];
        for(int i=0;i<dodai3;i++){
            if (i<dodai1){
                arr3[i]=arr1[i];
            } else {
                arr3[i]=arr2[i-arr1.length];
            }
        }
        //Xuat mang 3
        System.out.println();
        System.out.print("Mang sau khi gop: ");
        for (int element3:arr3){
            System.out.print(element3+" ");
        }
    }

}
