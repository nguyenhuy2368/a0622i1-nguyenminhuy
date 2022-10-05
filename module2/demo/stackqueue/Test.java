package codegym.vn.stackqueue;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student(20, "Tân");
        Student s2 = new Student(22, "Tú");
        Student s3 = new Student(21, "Châu");
        if (s1.compareTo(s2) > 0) {
            System.out.println("Tan lon hon Tu");
        } else if (s1.compareTo(s2) < 0) {
            System.out.println("Tan nho hon Tu");
        } else {
            System.out.println("Tan bang Tu");
        }
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
//        Collections.sort(students);
        Collections.sort(students, new CompareStudentByAgeAsc());
        students.forEach(System.out::println);
    }
}
