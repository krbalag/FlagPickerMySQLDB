package com.flagpicker.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flagpicker.springboot.exception.ResourceNotFoundException;
import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Post;
import com.flagpicker.springboot.repository.ContinentRepository;


import javax.validation.Valid;

@RestController
public class ContinentController {

    @Autowired
    ContinentRepository continentRepository;

    @GetMapping("/continents")
    public Page<Continent> getAllPosts(Pageable pageable) {
        return continentRepository.findAll(pageable);
    }

    @PostMapping("/continents")
    public Continent createContinent(@Valid @RequestBody Continent continent) {
        return continentRepository.save(continent);
    }

/*    @PutMapping("/continents/{continentId}")
    public Continent updateContinent(@PathVariable Long continentId, @Valid @RequestBody Continent continentRequest) {
        return continentRepository.findById(continentId).map(post -> {
            continent.setTitle(continentRequest.getTitle());
            continent.setDescription(continentRequest.getDescription());
            continent.setContent(continentRequest.getContent());
            return continentRepository.save(continent);
        }).orElseThrow(() -> new ResourceNotFoundException("ContinentId " + continentId + " not found"));
    }*/


    @DeleteMapping("/continents/{continentId}")
    public ResponseEntity<?> deleteContinent(@PathVariable Long continentId) {
        return continentRepository.findById(continentId).map(post -> {
        	continentRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ContinentId " + continentId + " not found"));
    }

}
