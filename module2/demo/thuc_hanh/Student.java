package ss4_class_object.thuc_hanh;

public class Student {
    // thuộc tính
    int id;
    String name;
    String email;

    public Student() {
    }
    // constructor 1 tham số
    public Student(int id) {
        this.id = id;
    }
    // constructor ( pt khởi tạo đối tượng)
    // constructor 3 tham số
    public Student(int id,String name,String email){
        // có thể gọi một constructor khác
        this(id, name);
        this.email=email;
    }
    // costructor 2 tham số
    public Student(int id,String name){
        this.id=id;
        this.name =name;
    }
    public void Student(){
        System.out.println("method cùng tên class");
    }
    // method
    public void study(String subject){
        System.out.println(this.name +" đang học môn "+ subject);
    }

    // khối lệnh
}
