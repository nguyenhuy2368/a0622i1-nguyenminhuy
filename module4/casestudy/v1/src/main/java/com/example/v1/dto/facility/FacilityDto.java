package com.example.v1.dto.facility;

import com.example.v1.entity.contract.Contract;
import com.example.v1.entity.facility.FacilityType;
import com.example.v1.entity.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacilityDto implements Validator {
    private Integer id;

    @NotBlank(message = "Tên dịch vụ không được để trống.")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}( \\d*)?)| *$",
            message = "Tên dịch vụ được phép chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")

    private String name;


    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích sử dụng phải là số nguyên dương.")
    private String area;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Chi phí thuê (VNĐ) phải là số nguyên dương.")
    private String cost;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số người tối đa phải là số nguyên dương.")
    private String maxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích hồ bơi phải là số nguyên dương.")
    private String poolArea;


    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số tầng phải là số nguyên dương.")
    private String numberOfFloors;

    private String facilityFree;

    private Integer isDelete = 1;

    private FacilityType facilityType;

    private RentType rentType;

    private Set<Contract> contracts;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
    }
}
