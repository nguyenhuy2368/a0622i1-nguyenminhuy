package com.example.controller;

import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService musicService;


    @GetMapping("/list")
   public String showList (Model model){
        model.addAttribute("musicList",musicService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String createMusic(@ModelAttribute Music music) {
        musicService.save(music);
        return "redirect:/music/list";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editMusic(@ModelAttribute Music music) {
        musicService.update(music.getId(), music);
        return "redirect:/music/edit";
    }

    @GetMapping("/delete")
    public String deleteMusic(@RequestParam int id) {
        musicService.remove(id);
        return "redirect:/music/delete";
    }

}
