package com.xathordroid.c1springbootform.services;

import com.xathordroid.c1springbootform.models.domain.Role;

import java.util.List;

public interface IRoleService {
    
    public List<Role> list();
    
    public Role getById(Integer id);
}
