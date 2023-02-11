package com.example.controller;

import com.example.model.MedicalInfor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalInforController {
    @GetMapping("/medical")
    private String showFormMedicalInfor(Model model) {
        model.addAttribute("yearBirth", new int[]{1996, 1997, 1998, 1999, 2001, 2002, 2003, 2004, 2005});
        model.addAttribute("nationality", new String[]{"Việt Nam", "Anh Quốc", "Hoa Kỳ", "Nhật Bản", "Hàn Q uốc"});
        model.addAttribute("vehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        model.addAttribute("medical",new MedicalInfor());
        return "medical";
    }
    @PostMapping("/result")
    private String showResult(@ModelAttribute("medical")MedicalInfor infor,Model model){
        model.addAttribute("medical",infor);
        return "result";
    }
}
