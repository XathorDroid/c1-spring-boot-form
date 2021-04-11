package com.xathordroid.c1springbootform.controllers;

import com.xathordroid.c1springbootform.editors.CountryPropertyEditor;
import com.xathordroid.c1springbootform.editors.RolePropertyEditor;
import com.xathordroid.c1springbootform.editors.UperCaseTextEditor;
import com.xathordroid.c1springbootform.models.domain.Country;
import com.xathordroid.c1springbootform.models.domain.Role;
import com.xathordroid.c1springbootform.models.domain.User;
import com.xathordroid.c1springbootform.services.ICountryService;
import com.xathordroid.c1springbootform.services.IRoleService;
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
import java.util.*;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private ICountryService countryService;

    @Autowired
    private IRoleService roleService;
    
    @Autowired
    private CountryPropertyEditor countryPropertyEditor;
    
    @Autowired
    private RolePropertyEditor rolePropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(dateFormat, true));
        
        binder.registerCustomEditor(String.class, "firstName", new UperCaseTextEditor());
        binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
        binder.registerCustomEditor(Role.class, "roles", rolePropertyEditor);
    }
    
    @GetMapping({ "", "/", "/index" })
    public String getForm(Model model) {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setIdentifier("123.456.789-G");
        user.setEnabled(true);
        user.setSecretValue("something hidden in front form");
        user.setCountry(new Country(2, "MEX", "México"));
        user.setRoles(Arrays.asList(new Role(2, "User", "ROLE_USER")));
        
        model.addAttribute("user", user);
        
        return "form";
    }
    
    @PostMapping("/save")
    public String saveForm(@Valid @ModelAttribute("user") User userCreated, BindingResult result, Model model, SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            return "form";
        }
        
        return "redirect:/show";
    } 
    
    @GetMapping("/show")
    public String showUser(@SessionAttribute("user") User user, Model model, SessionStatus sessionStatus) {
        if (user == null) return "redirect:/index";
        
        sessionStatus.setComplete();
        
        return "result";
    }
    
    @ModelAttribute("countries")
    public List<String> loadCountries() {
        return Arrays.asList("Spain", "México", "Chile", "England", "The US", "Germany");
    }
    
    @ModelAttribute("mapCountries")
    public Map<String, String> loadMapCountries() {
        Map<String, String> countries = new HashMap<>();

        countries.put("ES", "Spain ");
        countries.put("MEX", "México");
        countries.put("CH", "Chile");
        countries.put("ENG", "England");
        countries.put("US", "The US");
        countries.put("GER", "Germany");
                
        return countries;
    }

    @ModelAttribute("listCountries")
    public List<Country> loadListCountries() {
        return countryService.list();
    }

    @ModelAttribute("roles")
    public List<String> loadRoles() {
        List<String> roles = new ArrayList<>();
        
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        
        return roles;
    }

    @ModelAttribute("mapRoles")
    public Map<String, String> loadMapRoles() {
        Map<String, String> roles = new HashMap<>();
        
        roles.put("ROLE_ADMIN", "Admin");
        roles.put("ROLE_USER", "User");
        roles.put("ROLE_MODERATOR", "Moderator");
        
        return roles;
    }

    @ModelAttribute("listRoles")
    public List<Role> loadListRoles() {
        return roleService.list();
    }

    @ModelAttribute("genres")
    public List<String> loadGenres() {
        return Arrays.asList("Male", "Female");
    }
}
