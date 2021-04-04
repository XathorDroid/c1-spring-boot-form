package com.xathordroid.c1springbootform.controllers;

import com.xathordroid.c1springbootform.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    
    @GetMapping({ "", "/", "/index" })
    public String getForm(Model model) {
        return "form";
    }
    
    @PostMapping("/save")
    public String saveForm(Model model, @RequestParam(name="username") String user, @RequestParam String password, @RequestParam String email) {
        User userCreated = new User();
        userCreated.setUsername(user);
        userCreated.setPassword(password);
        userCreated.setEmail(email);
        
        model.addAttribute("user", userCreated);
        
        return "result";
    } 
}
