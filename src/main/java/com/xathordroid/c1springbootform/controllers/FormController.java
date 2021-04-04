package com.xathordroid.c1springbootform.controllers;

import com.xathordroid.c1springbootform.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {
    
    @GetMapping({ "", "/", "/index" })
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
    
    @PostMapping("/save")
    public String saveForm(@Valid @ModelAttribute("user") User userCreated, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), "El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
            });
            model.addAttribute("errors", errors);
            return "form";
        }
        
        model.addAttribute("user", userCreated);
        
        return "result";
    } 
}
