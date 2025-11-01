package com.olires.spring_boot_ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.olires.spring_boot_ecommerce.entity.State;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StatesRepository extends JpaRepository<State, Integer> { // State is the Entity Class, and Integer is the type of the primary key

    List<State> findByCountryCode(@Param("code") String code); // Custom query method to find states by country code
    
}