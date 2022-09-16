package ss5.bt.lop_chi_ghi;

public class Student {
    private String name = "Huy";
    private String classes = "A06";

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }
}
