package com.flagpicker.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Post;

/**
 * Created by balaji ramakrishnan .
 */
@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {

}
