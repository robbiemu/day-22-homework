package com.cooksys.day22.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.day22.homework.model.State;

public interface StateRepository extends JpaRepository<State, Long> {
}