package com.flagpicker.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Country;

/**
 * Created by balaji ramakrishnan .
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Page<Country> findByContinentId(Long continentId, Pageable pageable);
}
