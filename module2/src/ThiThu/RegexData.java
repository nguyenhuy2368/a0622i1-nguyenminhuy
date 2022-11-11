package ThiThu;

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
            System.out.println("Nhap dung format dd/MM/yyyy");
            return null;
        }
        Date now = new Date();
        if (now.getYear() - result.getYear() < 18) {
            System.out.println("Account chua du 18 tuoi");
        }
        return result;
    }
}
