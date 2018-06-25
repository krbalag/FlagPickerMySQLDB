package com.flagpicker.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flagpicker.springboot.exception.ResourceNotFoundException;

import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Country;

import com.flagpicker.springboot.repository.ContinentRepository;
import com.flagpicker.springboot.repository.CountryRepository;


import javax.validation.Valid;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    @GetMapping("/continents/{continentId}/countries")
    public Page<Country> getAllCountriesByContinentId(@PathVariable (value = "continentId") Long continentId,
                                                Pageable pageable) {
        return countryRepository.findByContinentId(continentId, pageable);
    }
  

    @PostMapping("/continents/{continentId}/countries")
    public Country createCountry(@PathVariable (value = "continentId") Long continentId,
                                 @Valid @RequestBody Country country) {
        return continentRepository.findById(continentId).map(post -> {
            country.setContinent(post);
            return countryRepository.save(country);
        }).orElseThrow(() -> new ResourceNotFoundException("Continent Id " + continentId + " not found"));
    }

    @PutMapping("/continents/{continentId}/countries/{countryId}")
    public Country updateCountry(@PathVariable (value = "continentId") Long continentId,
                                 @PathVariable (value = "countryId") Long countryId,
                                 @Valid @RequestBody Country countryRequest) {
        if(!continentRepository.existsById(continentId)) {
            throw new ResourceNotFoundException("Continent Id " + continentId + " not found");
        }
       
        
        return countryRepository.findById(countryId).map(country -> {
            country.setName(countryRequest.getName());
            return countryRepository.save(country);
        }).orElseThrow(() -> new ResourceNotFoundException("CountryId " + countryId + "not found"));
    }

    @DeleteMapping("/continents/{continentId}/countries/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable (value = "continentId") Long continentId,
                              @PathVariable (value = "countryId") Long countryId) {
        if(!continentRepository.existsById(continentId)) {
            throw new ResourceNotFoundException("Continent Id " + continentId + " not found");
        }

        return countryRepository.findById(countryId).map(country -> {
        	countryRepository.delete(country);
             return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Country Id " + countryId + " not found"));
    }
}
