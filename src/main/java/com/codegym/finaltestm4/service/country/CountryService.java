package com.codegym.finaltestm4.service.country;

import com.codegym.finaltestm4.model.Country;
import com.codegym.finaltestm4.repo.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CountryService implements ICountryService {

    @Autowired
    ICountryRepository countryRepository;


    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}
