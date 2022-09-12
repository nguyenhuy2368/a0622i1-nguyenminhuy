package _3_array.bt;
import java.util.Scanner;
public class TinhTongCacSoOCot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Nhap mang. Làm bài này nhớ dòng trước, cột sau là OK
        System.out.print("Nhap vao do rong mang: ");
        int dorong=scanner.nextInt();
        System.out.print("Nhap vao do dai mang: ");
        int dodai=scanner.nextInt();
        int [][] arr=new int[dorong][dodai];
        int indexdai=0;
        int indexrong=0;
        while (indexrong<dorong){
            while (indexdai<dodai){
                System.out.print("Phan tu thu ("+indexrong+","+indexdai+"): ");
                arr[indexrong][indexdai]=scanner.nextInt();
                indexdai++;
            }
            indexdai=0;
            indexrong++;
        }
        //Xuat mang
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    //Tinh tong cot nhap vao
        System.out.print("Nhap vao cot muon tinh tong: ");
        int columnSum=scanner.nextInt();
        int sum=0;
        for (int k=0;k<arr.length;k++){
            //Dòng trước, cột sau
            sum+=arr[k][columnSum];
        }
        System.out.print("Tong cua cot "+columnSum+" la: "+sum);
    }

}
