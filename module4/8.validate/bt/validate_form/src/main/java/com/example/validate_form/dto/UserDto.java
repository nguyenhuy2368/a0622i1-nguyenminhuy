package com.example.validate_form.dto;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;
    @NotEmpty(message = "First name not empty")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotEmpty(message = "First name not empty")
    @Size(min = 5, max = 45)
    private String lastName;
    @NotBlank(message = "Phone number not empty")
    private String phone;
    @Range(min = 18,max = 100)
    private int age;
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phone, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (!userDto.getFirstName().isEmpty()) {
            if (userDto.getFirstName().length() < 4 || userDto.getFirstName().length() > 46) {
                errors.rejectValue("firstName", "firstName.regex.failed", "Tên chỉ được có từ 5 đến 45 kí tự");
            }
        }
        if (!userDto.getLastName().isEmpty()) {
            if (userDto.getLastName().length() < 4 || userDto.getFirstName().length() > 46) {
                errors.rejectValue("lastName", "lastName.regex.failed", "Họ chỉ được có từ 5 đến 45 kí tự");
            }
        }
        if (!userDto.getPhone().isEmpty()) {
            if (!userDto.getPhone().matches("^0\\d{9}|[(]84[)][+]\\d{9}$")) {
                errors.rejectValue("phone", "phoneNumber.regex.failed", "Không đúng định dạng");
            }
        }

        if (!userDto.getEmail().isEmpty()) {
            if (!userDto.getEmail().matches("^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
                errors.rejectValue("email", "email.regex.failed", "Email cần đúng định dạng");
            }
        }
    }
}
