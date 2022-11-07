package codegym.vn.textfile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
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

    public static void writeFileOptimize(List<Student> students, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))){
            for (Student student: students) {
                buffered.write(student.getInfo());
                buffered.newLine();
            }
//            buffered.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFile(String filename) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                list.add(new Student(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
//    public Student(String str) {
//        String[] data = str.split(",");
//        this.id = data[0];
//        this.age = Integer.parseInt(data[2]);
//        this.name = data[1];
//        this.address = data[3];
//    }
}
