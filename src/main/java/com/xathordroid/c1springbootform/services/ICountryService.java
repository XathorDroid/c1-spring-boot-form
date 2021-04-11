package com.xathordroid.c1springbootform.services;

import com.xathordroid.c1springbootform.models.domain.Country;

import java.util.List;

public interface ICountryService {
    
    public List<Country> list();
    
    public Country getById(Integer id);
}
