package ss5.th.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(111,"abc");
        Student s2 = new Student(222,"xyz");
        Student s3 = new Student(333,"ghi");
        s1.display();
        s2.display();
        s3.display();

    }
}
