package com.example.v1.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContractDetailDto {
    private Integer id;
    private Integer quantity;
    private Integer attachFacilityId;
    private Integer contractId;
}
