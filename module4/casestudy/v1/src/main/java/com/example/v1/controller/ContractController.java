package com.example.v1.controller;

import com.example.v1.dto.contract.ContractDetailDto;
import com.example.v1.dto.contract.IContractDto;
import com.example.v1.entity.contract.AttachFacility;
import com.example.v1.entity.contract.Contract;
import com.example.v1.entity.contract.ContractDetail;
import com.example.v1.serivce.contract.IAttachFacilityService;
import com.example.v1.serivce.contract.IContractDetailService;
import com.example.v1.serivce.contract.IContractService;
import com.example.v1.serivce.customer.ICustomerService;
import com.example.v1.serivce.employee.IEmployeeService;
import com.example.v1.serivce.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    IAttachFacilityService attachFacilityService;

    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    IFacilityService facilityService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IEmployeeService employeeService;

    @GetMapping
    public String showList(Model model, @PageableDefault(value = 3) Pageable pageable) {
        Page<IContractDto> contractServiceDtos = contractService.findAllDto(pageable);
        model.addAttribute("contracts", contractServiceDtos);
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract/list";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Contract contract,
                       RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Add new contract successfully!");
        return "redirect:/contract";
    }

    @PostMapping("/create-contract-detail")
    public String saveDetail(@ModelAttribute ContractDetailDto contractDetailDto, RedirectAttributes redirectAttributes) {

        ContractDetail contractDetailATBC = new ContractDetail();

        Optional<Contract> contractATBC = contractService.findById(contractDetailDto.getContractId());
        Optional<AttachFacility> attachFacilityATBC =
                attachFacilityService.findById(contractDetailDto.getAttachFacilityId());

        BeanUtils.copyProperties(contractDetailDto, contractDetailATBC);

        contractDetailATBC.setContract(contractATBC.get());
        contractDetailATBC.setAttachFacility(attachFacilityATBC.get());

        contractDetailService.save(contractDetailATBC);


        redirectAttributes.addFlashAttribute("message",
                "New contract detail added successfully!");


        return "redirect:/contract";
    }

    @GetMapping("/{id}")
    public String showAttachFacility(@PathVariable Integer id, Model model) {
        model.addAttribute("contractDetails", contractDetailService.showAll(id));
        return "redirect:/contract";
    }
}
