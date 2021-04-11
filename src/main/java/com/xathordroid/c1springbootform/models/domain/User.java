package com.xathordroid.c1springbootform.models.domain;

import com.xathordroid.c1springbootform.validators.IdentifierRegex;
import com.xathordroid.c1springbootform.validators.Required;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class User {

    @IdentifierRegex
    private String identifier;
    
    @NotEmpty(message = "Debe intrducir un nombre")
    private String firstName;
    
    private String lastName;
    
    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @Required
    private String password;

    @NotEmpty
    @Email(message = "El formato de email no es correcto :)")
    private String email;

    @NotNull
    @Min(5)
    @Max(5000)
    private Integer count;

    @NotNull
    @Past
    private Date birthday;
    
    @NotNull
    private Country country;
    
    @NotEmpty
    private List<Role> roles;

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
