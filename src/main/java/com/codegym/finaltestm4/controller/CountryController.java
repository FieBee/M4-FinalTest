package com.codegym.finaltestm4.controller;

import com.codegym.finaltestm4.model.Country;
import com.codegym.finaltestm4.service.country.CountryService;
import com.codegym.finaltestm4.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ResponseEntity<Iterable<Country>> findAllCountry(){
        List<Country> countries =(List<Country>) countryService.findAll();

        if(countries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(countries,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable Long id) {
        Optional<Country> Country = countryService.findById(id);
        if (!Country.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Country.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country Country) {
        Optional<Country> CountryOptional = countryService.findById(id);
        if (!CountryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Country.setId(CountryOptional.get().getId());
        return new ResponseEntity<>(countryService.save(Country), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
        Optional<Country> CountryOptional = countryService.findById(id);
        if (!CountryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.remove(id);
        return new ResponseEntity<>(CountryOptional.get(), HttpStatus.NO_CONTENT);
    }


}
