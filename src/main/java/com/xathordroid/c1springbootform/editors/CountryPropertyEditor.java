package com.xathordroid.c1springbootform.editors;

import com.xathordroid.c1springbootform.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private ICountryService countryService;

    @Override
    public void setAsText(String countryId) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(countryId);
            this.setValue(countryService.getById(id));
        } catch (NumberFormatException e) {
            this.setValue(null);
        }
    }
}
