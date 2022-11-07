package case_study.models.person;

import case_study.models.person.Person;

import java.util.Date;

public class Employee extends Person {
    private String employeeId;
    private String degree; // bằng cấp
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String name, String birthDay, String gender, String cmnd, String phone, String email, String employeeId, String degree, String position, int salary) {
        super(name, birthDay, gender, cmnd, phone, email);
        this.employeeId = employeeId;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
