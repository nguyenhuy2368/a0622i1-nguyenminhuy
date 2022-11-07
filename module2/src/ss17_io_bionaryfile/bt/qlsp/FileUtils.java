package ss17_io_bionaryfile.bt.qlsp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void writeFile(List<Product> products, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))){
            for (Product student: products) {
                buffered.write(student.getInfo());
                buffered.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readFile(String filename) {
        List<Product> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                list.add(new Product(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
