package com.cooksys.day22.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cooksys.day22.homework.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}