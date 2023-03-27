package com.example.v1.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContractDto {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private String employeeId;
    private String customerId;
    private String contractDetailId;
    private String facilityId;
}
