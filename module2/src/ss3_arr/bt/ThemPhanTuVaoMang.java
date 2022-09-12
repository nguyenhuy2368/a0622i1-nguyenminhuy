package _3_array.bt;
import java.util.Scanner;
public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap vao do dai cua mang: ");
        int dodai=scanner.nextInt();
        int [] arr=new int[dodai];
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
        System.out.print("Nhap so can chen: ");
        int addNumber=scanner.nextInt();
        System.out.print("Nhap vi tri chen: ");
        int addIndex=scanner.nextInt();
        if ((addIndex<=1) || (addIndex>=arr.length-1)){
            System.out.print("Khong thc chen duoc");
        } else{
            int [] newArr=new int[dodai+1];
            for (int i=0;i<addIndex;i++){
                newArr[i]=arr[i];
                }
            newArr[addIndex]=addNumber;
            for(int j=addIndex;j<arr.length;j++){
                newArr[j+1]=arr[j];

            }
            System.out.print("Do dai mang sau khi them:");
            for (int element:newArr){
                System.out.print(element+" ");
            }
        }
    }
}
