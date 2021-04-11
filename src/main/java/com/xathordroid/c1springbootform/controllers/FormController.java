package com.xathordroid.c1springbootform.controllers;

import com.xathordroid.c1springbootform.models.domain.User;
import com.xathordroid.c1springbootform.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(dateFormat, true));
    }
    
    @GetMapping({ "", "/", "/index" })
    public String getForm(Model model) {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setIdentifier("123.456.789-G");
        
        model.addAttribute("user", user);
        
        return "form";
    }
    
    @PostMapping("/save")
    public String saveForm(@Valid @ModelAttribute("user") User userCreated, BindingResult result, Model model, SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            return "form";
        }
        
        model.addAttribute("user", userCreated);
        
        sessionStatus.setComplete();
        
        return "result";
    } 
}
