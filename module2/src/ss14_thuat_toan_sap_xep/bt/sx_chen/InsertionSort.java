package ss14_thuat_toan_sap_xep.bt.sx_chen;

public class InsertionSort {
    public static void sort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int x = list[i];
            int pos = i ;
            while (pos > 0 && list[pos-1] > x) {
                list[i] = list[pos];
                pos--;
            }
            list[pos]=x;
        }
    }

    public static void main(String[] args) {
        int[] myArray = {9, 1, 3, 12, 4, 23, 45};
        sort(myArray);
        for (int value: myArray) {
            System.out.print(value+" ");
        }
    }
}
