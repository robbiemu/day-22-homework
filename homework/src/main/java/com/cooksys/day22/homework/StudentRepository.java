package com.cooksys.day22.homework;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cooksys.day22.homework.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByCity(String city);
}