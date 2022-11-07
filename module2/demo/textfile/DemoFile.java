package codegym.vn.textfile;

import java.util.ArrayList;
import java.util.List;

public class DemoFile {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("SV001", "Tú", 30, "Đà Nẵng"));
        students.add(new Student("SV002", "Châu", 25, "Quảng Nam"));
        students.add(new Student("SV003", "Tân", 21, "Mỹ Tho"));
        students.add(new Student("SV004", "Tài", 40, "Quảng Bình"));
        students.add(new Student("SV005", "Huy", 24, "Kontum"));

        FileUtils.writeFileOptimize(students, "student.csv");

        List<Student> studentList = FileUtils.readFile("student.csv");
        studentList.forEach(System.out::println);
    }
}
