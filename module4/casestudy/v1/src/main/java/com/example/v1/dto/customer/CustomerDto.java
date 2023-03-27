package com.example.v1.dto.customer;

import com.example.v1.entity.contract.Contract;
import com.example.v1.entity.customer.CustomerType;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CustomerDto implements Validator {
    private Integer id;

    @NotBlank(message = "Tên không được để trống.")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5})| *$",
            message = "Tên khách hàng không được chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;

    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])$",
            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    private String dateOfBirth;
    @NotNull(message = "Vui lòng chọn giới tính.")
    private Integer gender;
    @NotBlank(message = "Số CMND/CCCD không được để trống.")
    @Pattern(regexp = "^(\\d{9}|\\d{12})| *$",
            message = "Số CMND/CCCD phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^((0|[(]84[)][+])9[01]\\d{7})| *$", message =
            "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;
    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Địa chỉ email phải đúng định dạng.")
    private String email;
    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;

    private Integer isDelete;

    private CustomerType customerType;

    private Set<Contract> contracts;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto =(CustomerDto) target;
    }
}
