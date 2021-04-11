package com.xathordroid.c1springbootform.editors;

import com.xathordroid.c1springbootform.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {

    @Autowired
    private IRoleService roleService;

    @Override
    public void setAsText(String roleId) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(roleId);
            this.setValue(roleService.getById(id));
        } catch (NumberFormatException e) {
            this.setValue(null);
        }
    }
}
