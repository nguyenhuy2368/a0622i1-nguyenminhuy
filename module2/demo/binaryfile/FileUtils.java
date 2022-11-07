package codegym.vn.binaryfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void writeFileOptimize(List<Student> students, String filename) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename))) {
            stream.writeObject(students);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFile(String filename) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
