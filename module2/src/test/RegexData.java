package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegexData {
    public static Scanner sc = new Scanner(System.in);
    public static String regex(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = sc.nextLine();
            }
        } while (check);
        return temp;
    }
    public static Date validateDate(String dateAsString)  {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date result = null;
        try {
            result = format.parse(dateAsString);
        } catch (ParseException e) {
            System.out.println("Ngay sinh khong hop le. Format chua dung dd/MM/yyyy");
            return null;
        }
        return result;
    }
}

