package com.xathordroid.c1springbootform.services;

import com.xathordroid.c1springbootform.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    
    private List<Role> roles;

    public RoleService() {
        this.roles = Arrays.asList(
                new Role(1, "Admin", "ROLE_ADMIN"),
                new Role(2, "User", "ROLE_USER"),
                new Role(3, "Moderator", "ROLE_MODERATOR")
        );
    }

    @Override
    public List<Role> list() {
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        Role roleResult = null;
        
        for (Role role : this.roles) {
            if (id.equals(role.getId())) {
                roleResult = role;
                break;
            }
        }
        
        return roleResult;
    }
}
