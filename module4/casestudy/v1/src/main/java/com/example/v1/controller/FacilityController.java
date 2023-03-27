package com.example.v1.controller;

import com.example.v1.dto.facility.FacilityDto;
import com.example.v1.entity.facility.Facility;
import com.example.v1.serivce.facility.IFacilityService;
import com.example.v1.serivce.facility.IFacilityTypeService;
import com.example.v1.serivce.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping
    public String showList(@RequestParam(value = "nameSearch", defaultValue = "") String name,
                           @RequestParam(value = "facilityType", defaultValue = "") String typeName,
                           @PageableDefault(value = 3) Pageable pageable,
                           Model model) {
        Page<Facility> facilityPage = facilityService.findByNameAndFacilityType(name, typeName, pageable);

        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        model.addAttribute("searchName", name);
        model.addAttribute("searchFacilityType", typeName);
        return "facility/list";
    }

    @GetMapping("/create")
    public String showCreateFacility(Model model) {
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/create";
    }

    @PostMapping("/save")
    public String saveFacility(@Validated @ModelAttribute FacilityDto facilityDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityType", facilityTypeService.findAll());
            model.addAttribute("rentType", rentTypeService.findAll());
            return "/facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Add New Facility successfully!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Facility> optionalFacility = facilityService.findById(id);
        if (!optionalFacility.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facility";
        }
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(optionalFacility.get(), facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "facility/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(value = "facilityDto") FacilityDto facilityDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(facilityDto.getId());
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facility";
        }
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility saved successfully");
            return "redirect:/facility";
        } else {
            redirect.addFlashAttribute("message", "Facility saved failed");
            return "redirect:/facility";
        }
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(id);
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facility";
        }
        model.addAttribute("facility", optionalFacility.get());
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam(value = "idDelete") String id, RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(Integer.parseInt(id));
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
        } else {
            Facility facility = optionalFacility.get();
            facility.setIsDelete(0);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility removed!");
        }
        return "redirect:/facility";
    }
}
