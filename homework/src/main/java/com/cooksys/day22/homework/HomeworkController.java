package com.cooksys.day22.homework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.day22.homework.model.Student;
import com.cooksys.day22.homework.springview.StudentView;

import tx.DBTXResponse;

@RestController
//@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.PUT})
@CrossOrigin(methods = RequestMethod.POST)
public class HomeworkController {
	@Autowired
	HomeworkService cheater;

	@RequestMapping(value="student", method=RequestMethod.POST)
	public Student getStudent(@RequestBody Student student) {
		return cheater.createStudent(student);
	}
	
	@RequestMapping("student/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		return cheater.readStudent(id);
	}

	@RequestMapping("students")
	public List<StudentView> getStudents() {
		return cheater.readStudents();
	}
	
	@RequestMapping("students/city/{city}")
	public DBTXResponse<StudentView> getStudents(@PathVariable String city) {
		return cheater.readStudentsByCity(city);
	}
	
}
