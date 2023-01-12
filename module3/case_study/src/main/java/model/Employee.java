package model;

public class Employee {
    private int employeeId;
    private String name;
    private String birthday;
    private int cardId;
    private int salary;
    private String phoneNumber;
    private String email;
    private String address;
    private Division level;
    private Position position;
    private EducationDegree educationDegree;



    public Employee(int employeeId, String name, String birthday, int cardId, String phoneNumber, String email, Division level, Position position, EducationDegree educationDegree, int salary, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthday = birthday;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.position = position;
        this.educationDegree = educationDegree;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String name, String birthday, int cardId, String phoneNumber, String email, Division level, Position position, EducationDegree educationDegree, int salary, String address) {
        this.name = name;
        this.birthday = birthday;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.position = position;
        this.educationDegree = educationDegree;
        this.salary = salary;
        this.address = address;
    }

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Division getLevel() {
        return level;
    }

    public void setLevel(Division level) {
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
