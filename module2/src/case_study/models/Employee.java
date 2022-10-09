package case_study.models;

import java.util.Date;

public class Employee extends Person {
    private int employeeId;
    private String degree;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String name, Date birthDay, String gender, String cmnd, Number phone, String email, int employeeId, String degree, String position, int salary) {
        super(name, birthDay, gender, cmnd, phone, email);
        this.employeeId = employeeId;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

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
                "employeeId=" + employeeId +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
