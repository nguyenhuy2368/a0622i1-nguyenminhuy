package com.example.v1.serivce.contract;

import com.example.v1.dto.contract.IContractDto;
import com.example.v1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    Page<IContractDto> findAllDto(Pageable pageable);

    Optional<Contract> findById(int id);

    void save(Contract contract);
}
