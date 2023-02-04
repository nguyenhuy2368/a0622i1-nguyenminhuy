package com.example.controller;

import com.example.repository.DictionaryRepository;
import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping("dictionary")
    public String dictionary() {
        return "dictionary";
    }

    @PostMapping("search")
    public String search(@RequestParam("word") String word, Model model) {
        IDictionaryRepository iDictionaryRepository = new DictionaryRepository();
        String result = iDictionaryRepository.search(word);
        model.addAttribute("word", word);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
