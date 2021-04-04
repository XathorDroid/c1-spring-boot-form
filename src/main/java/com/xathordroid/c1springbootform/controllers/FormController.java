package com.xathordroid.c1springbootform.controllers;

import com.xathordroid.c1springbootform.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    
    @GetMapping({ "", "/", "/index" })
    public String getForm(Model model) {
        return "form";
    }
    
    @PostMapping("/save")
    public String saveForm(User userCreated, Model model) {
        model.addAttribute("user", userCreated);
        return "result";
    } 
}
