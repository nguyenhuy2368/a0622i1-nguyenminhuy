package _3_array.bt;
import java.util.Scanner;
public class TongDuongCheoChinh {
    public static void main(String[] args) {
        // Làm bài này nhớ dòng (dài) trước, cột (dài) sau là OK.
        //Nhap mang.
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap vao do lon cua mang: ");
        int dolon=scanner.nextInt();
        int arr [][]=new int[dolon][dolon];
        int indexdong=0;
        int indexcot=0;
        while (indexdong<dolon){
            while(indexcot<dolon){
                System.out.print("Nhap phan tu thu ("+indexdong+","+indexcot+"): ");
                arr[indexdong][indexcot]=scanner.nextInt();
                indexcot++;
            }
            indexcot=0;
            indexdong++;
        }
        //Xuat mang
        System.out.println("Mang da tao la: ");
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        //Tinh tong
        int sum=0;
        for (int m=0;m<arr.length;m++){
            for (int n=0;n<arr.length;n++){
                if(m==n){
                    sum+=arr[m][n];
                }
            }
        }
        System.out.println("Tong duong cheo chinh la: "+sum);
    }
}

