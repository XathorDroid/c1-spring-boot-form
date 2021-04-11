package com.xathordroid.c1springbootform.services;

import com.xathordroid.c1springbootform.models.domain.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService implements ICountryService {
    
    private List<Country> countries;

    public CountryService() {
        this.countries = Arrays.asList(new Country(1, "ES", "Spain"),
                new Country(2, "MEX", "México"),
                new Country(3, "CH", "Chile"),
                new Country(4, "ENG", "England"),
                new Country(5, "US", "The US"),
                new Country(6, "GER", "Germany")
        );
    }

    @Override
    public List<Country> list() {
        return countries;
    }

    @Override
    public Country getById(Integer id) {
        Country countryResult = null;
        
        for (Country country : this.countries) {
            if (id.equals(country.getId())) {
                countryResult = country;
                break;
            }
        }
        
        return countryResult;
    }
}
