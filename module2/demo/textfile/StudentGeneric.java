package codegym.vn.textfile;

public class StudentGeneric implements WriteAble {
    private String id;
    private int age;
    private String name;
    private String address;

    public StudentGeneric() {
    }

    public StudentGeneric(String id, String name, int age, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getInfo() {
        return this.id + "," + this.name + "," + this.age + "," + this.address;
    }

    @Override
    public Object inputInfo(String str) {
        String[] data = str.split(",");
        this.id = data[0];
        this.age = Integer.parseInt(data[2]);
        this.name = data[1];
        this.address = data[3];
        return new StudentGeneric(id, name, age, address);
    }
}
