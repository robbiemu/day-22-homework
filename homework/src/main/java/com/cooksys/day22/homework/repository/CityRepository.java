package com.cooksys.day22.homework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cooksys.day22.homework.model.City;
import com.cooksys.day22.homework.model.State;

public interface CityRepository extends JpaRepository<City, Long> {
	City findOneByName(String name);
	List<City> findByState(State state);
}