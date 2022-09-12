package _3_array.bt;
import java.util.Scanner;
public class XoaPhanTuTrongMang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arr[];
        System.out.print("Nhap vao do dai cua mang: ");
        int dodai=scanner.nextInt();
        arr=new int[dodai];
        int index=0;
        while (index<dodai){
            System.out.print("Nhap phan tu thu "+(index+1)+": ");
            arr[index]=scanner.nextInt();
            index++;
        }
        System.out.print("Mang ban dau: ");
        for (int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.print("Nhap vao phan tu can xoa: ");
        int deleteElement=scanner.nextInt();
        int [] newArr=new int[dodai];
        boolean isExist=false;
        for (int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
            if (arr[i]==deleteElement){
                isExist=true;
                for (int j=i;j<arr.length-1;j++){
                    newArr[j]=arr[j+1];
                }
                break;
            }
        }
        if(!isExist){
            System.out.println("Khong co phan tu de xoa");
        } else{
            System.out.print("Mang sau khi xoa: ");
            for (int element:newArr){
                System.out.print(element+" ");
        }

        }
    }

}

