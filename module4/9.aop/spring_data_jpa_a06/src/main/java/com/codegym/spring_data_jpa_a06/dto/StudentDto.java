package com.codegym.spring_data_jpa_a06.dto;

import com.codegym.spring_data_jpa_a06.model.ClassRoom;
import com.codegym.spring_data_jpa_a06.model.Jame;
import com.codegym.spring_data_jpa_a06.model.Subject;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;


public class StudentDto implements Validator {

    private int id;
//    @NotNull(message = "Không được null")
    @NotEmpty(message = "Yêu cầu nhập tên")
    @Size(min = 3,max = 10, message = "độ dài từ 3-10 ký tự")
    @Pattern(regexp = "^[a-zA-Z]+$",message = "Tên chỉ chứa ký tự chữ")
    private String name;
    private int gender;
    private String phoneNumber;
    private Jame jame;
    private ClassRoom classRoom;
    private Set<Subject> subjectSet;

    public StudentDto() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudentDto(int id, String name, int gender, String phoneNumber, Jame jame, ClassRoom classRoom, Set<Subject> subjectSet) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.jame = jame;
        this.classRoom = classRoom;
        this.subjectSet = subjectSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Jame getJame() {
        return jame;
    }

    public void setJame(Jame jame) {
        this.jame = jame;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        StudentDto studentDto = (StudentDto) target;
        String phoneNumber = studentDto.getPhoneNumber();
        if (phoneNumber.length()<10){
            errors.rejectValue("phoneNumber","name.errors1","SDT chưa đủ dài");
        }else if (phoneNumber.length()>11){
            errors.rejectValue("phoneNumber","name.errors2","Số điện thoại quá dài");
        }else if (!phoneNumber.matches("^\\d+$")){
            errors.rejectValue("phoneNumber","null","SDT chỉ chứa ký tự số");
        }

    }
}
