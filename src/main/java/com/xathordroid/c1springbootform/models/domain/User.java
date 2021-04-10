package com.xathordroid.c1springbootform.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    private String identifier;
    
    @NotEmpty(message = "Debe intrducir un nombre")
    private String firstName;
    
    private String lastName;
    
    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email(message = "El formato de email no es correcto :)")
    private String email;

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
}
