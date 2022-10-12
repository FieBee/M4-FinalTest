package com.codegym.finaltestm4.service.city;

import com.codegym.finaltestm4.model.City;
import com.codegym.finaltestm4.repo.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CityService implements ICityService{

    @Autowired
    ICityRepository cityRepository;

    @Override
    public Iterable findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
}
