package com.codegym.finaltestm4.controller;



import com.codegym.finaltestm4.model.City;
import com.codegym.finaltestm4.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAllCity(){
       List<City> Citys =(List<City>) cityService.findAll();

       if(Citys.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(Citys,HttpStatus.OK);
   }

    @GetMapping("/{id}")
    public ResponseEntity<City> findCityById(@PathVariable Long id) {
        Optional<City> City = cityService.findById(id);
        if (!City.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(City.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City City) {
        return new ResponseEntity<>(cityService.save(City), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City City) {
        Optional<City> CityOptional = cityService.findById(id);
        if (!CityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        City.setId(CityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(City), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        Optional<City> CityOptional = cityService.findById(id);
        if (!CityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(CityOptional.get(), HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/home")
//    public ModelAndView getAllCitys() {
//        ModelAndView modelAndView = new ModelAndView("City/home");
//        modelAndView.addObject("City", CityService.findAll());
//        return modelAndView;
//    }

}
