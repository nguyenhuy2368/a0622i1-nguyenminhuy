package com.example.v1.serivce.contract;

import com.example.v1.dto.contract.IContractDetailDto;
import com.example.v1.entity.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    List<IContractDetailDto> showAll(Integer id);

    void save(ContractDetail contractDetail);

    List<ContractDetail> getListAttachContract(Integer id);
}
