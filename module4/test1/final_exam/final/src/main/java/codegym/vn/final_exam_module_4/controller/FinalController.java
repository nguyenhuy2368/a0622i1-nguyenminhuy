package codegym.vn.final_exam_module_4.controller;

import codegym.vn.final_exam_module_4.model.GiaoDich;
import codegym.vn.final_exam_module_4.service.IGiaoDichService;
import codegym.vn.final_exam_module_4.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/final")
public class FinalController {
    @Autowired
    IGiaoDichService giaoDichService;
    @Autowired
    IKhachHangService khachHangService;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("giaoDichs",giaoDichService.findAll());
        model.addAttribute("khachHangs", khachHangService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("giaoDich", new GiaoDich());
        model.addAttribute("khachHangs", khachHangService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@Valid @ModelAttribute("giaoDich") GiaoDich giaoDich, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("khachHangs", khachHangService.findAll());
            return "create";
        }
        giaoDichService.create(giaoDich);
        return "redirect:/final/index";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id")String id,Model model){
        model.addAttribute("giaoDich", giaoDichService.finById(id));
        return "view";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id,Model model) {
        giaoDichService.delete(id);
        model.addAttribute("mess","xóa thành công");
        return "redirect:/final/index";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name")String name, Model model){
        model.addAttribute(khachHangService.findByName(name));
        return "index";
    }



}