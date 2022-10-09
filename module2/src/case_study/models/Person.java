package case_study.models;

import java.util.Date;

public class Person {
    private String name;
    private Date birthDay;
    private String gender;
    private String cmnd;
    private Number phone;
    private String email;

    public Person() {
    }

    public Person(String name, Date birthDay, String gender, String cmnd, Number phone, String email) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", gender='" + gender + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
