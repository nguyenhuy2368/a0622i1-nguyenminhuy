package ss1.bt;

import java.util.Scanner;

public class Readnumber {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        String[] donVi = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] chuc = {"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        System.out.println("input you number: ");
        int number = Scanner.nextInt();
        int hangDonVi = (number % 100) % 10;
        int hangChuc = (number % 100) / 10;
        int hangTram = number / 100;
        String chuc1 = "";
        switch (hangDonVi) {
            case 0:
                chuc1 = chuc[hangDonVi];
                break;
            case 1:
                chuc1 = "eleven";
                break;
            case 2:
                chuc1 = "twelve";
                break;
            case 3:
                chuc1 = "thirteen";
                break;
            case 4:
                chuc1 = "fourteen";
                break;
            case 5:
                chuc1 = "fifteen";
                break;
            case 6:
                chuc1 = "sixteen";
                break;
            case 7:
                chuc1 = "seventeen";
                break;
            case 8:
                chuc1 = "eighteen";
                break;
            case 9:
                chuc1 = "nineteen";
                break;
        }
        if (hangTram >= 1) {
            if (hangChuc == 1) {

                System.out.println(donVi[hangTram] + " hundred and " + chuc1);
            } else if (hangChuc > 1) {
                System.out.println(donVi[hangTram] + " hundred and " + chuc[hangChuc - 1] + "-" + donVi[hangDonVi]);
            } else {
                if (hangDonVi == 0) {
                    System.out.println(donVi[hangTram]);
                } else {
                    System.out.println(donVi[hangTram] + " hundred and " + donVi[hangDonVi]);
                }
            }
        } else {
            if (hangChuc > 1) {
                System.out.println(chuc[hangChuc - 1] + "-" + donVi[hangDonVi]);
            } else if (hangChuc == 1) {
                System.out.println(chuc1);
            } else {
                if (hangDonVi == 0) {
                    System.out.println("zero");
                } else {
                    System.out.println(donVi[hangDonVi]);
                }
            }
        }
    }
}
