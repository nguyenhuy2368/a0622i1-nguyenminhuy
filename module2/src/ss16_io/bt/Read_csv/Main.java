package ss16_io.bt.Read_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        countries = readFile("D:\\A0622I1\\module2\\src\\ss16_io\\bt\\Read_csv\\country.csv");
        countries.forEach(System.out::println);
    }
    public static List<Country> readFile(String filename) {
        List<Country> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line=null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                list.add(new Country(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
