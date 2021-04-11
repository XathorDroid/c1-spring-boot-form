package com.xathordroid.c1springbootform.models.domain;

public class Role {
    
    private Integer id;
    private String name;
    private String role;

    public Role() {}
    
    public Role(Integer id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        
        Role role = (Role) o;
        return this.id != null && this.id.equals(role.getId());
    }
}
