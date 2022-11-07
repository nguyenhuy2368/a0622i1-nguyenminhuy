package case_study.models.person;

import java.util.Date;

public class Person {
    private String name;
    private String birthDay;
    private String gender;
    private String cmnd;
    private String phone;
    private String email;

    public Person() {
    }


    public Person(String name, String birthDay, String gender, String cmnd, String phone, String email) {
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

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
