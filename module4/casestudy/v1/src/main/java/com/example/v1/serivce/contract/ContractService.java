package com.example.v1.serivce.contract;

import com.example.v1.dto.contract.IContractDto;
import com.example.v1.entity.contract.Contract;
import com.example.v1.repository.contract.IContracRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractService implements IContractService {
    @Autowired
    IContracRepository contracRepository;

    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return contracRepository.findAllDto(pageable);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contracRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contracRepository.save(contract);
    }
}
