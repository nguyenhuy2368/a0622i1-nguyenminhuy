package _3_array.bt;
import java.util.Scanner;
public class TimMinTrongMang {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        //Nhap mang
        System.out.print("Nhap do dai cua mang: ");
        int dodai=scanner.nextInt();
        int [] arr=new int[dodai];
        int index=0;
        while (index<dodai){
            System.out.print("Nhap phan tu thu "+(index+1)+": ");
            arr[index]=scanner.nextInt();
            index++;
        }
        //Xuat mang
        System.out.print("Mang vua nhap: ");
        for (int element:arr){
            System.out.print(element+" ");
        }
        //Tim gia tri nho nhat
        int min=arr[1];
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println();
        System.out.print("Gia tri nho nhat la:"+min  );
    }


}
