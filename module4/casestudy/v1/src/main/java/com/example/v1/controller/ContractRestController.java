package com.example.v1.controller;

import com.example.v1.dto.contract.IContractDetailDto;
import com.example.v1.serivce.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/contract/v1")
public class ContractRestController {

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/contract-detail/{contractId}")
    public ResponseEntity<List<IContractDetailDto>> getListContractDetail(@PathVariable Integer contractId) {
        List<IContractDetailDto> contractDetailList = contractDetailService.showAll(contractId);
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
}
