package codegym.vn.textfile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtilsGeneric {
    public static void writeFile(List<Student> students, String filename) {
        BufferedWriter buffered = null;
        try {
            buffered = new BufferedWriter(new FileWriter(filename));
            for (Student student: students) {
                buffered.write(student.getInfo());
                buffered.newLine();
            }
            buffered.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffered != null) {
                try {
                    buffered.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T extends WriteAble> void writeFileOptimize(List<T> lists, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))){
            for (T entity: lists) {
                buffered.write(entity.getInfo());
                buffered.newLine();
            }
//            buffered.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends WriteAble> List<T> readFile(String filename) {
        List<T> list = new ArrayList<>();
        T entity = (T) new Object();
        try {
            entity.getClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                list.add((T) entity.inputInfo(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
