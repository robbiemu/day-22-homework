package com.cooksys.day22.homework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.day22.homework.model.City;
import com.cooksys.day22.homework.model.State;
import com.cooksys.day22.homework.model.Student;
import com.cooksys.day22.homework.springview.StudentView;
import com.cooksys.day22.homework.tx.DBTXResponse;

@RestController
//@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.PUT})
@CrossOrigin(methods = RequestMethod.POST)
public class HomeworkController {
	@Autowired
	HomeworkService cheater;

	@RequestMapping(value="student", method=RequestMethod.POST)
	public Student postStudent(@RequestBody Student student) {
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

	@RequestMapping(value="students/city/{city}", method=RequestMethod.POST)
	public Student postCityOfStudent(@PathVariable Long city) {
		return cheater.createCityofStudent(city);
	}

	@RequestMapping(value="students/state/{state}", method=RequestMethod.POST)
	public Student postStateOfStudent(@PathVariable Long state) {
		return cheater.createStateofStudent(state);
	}

	
	@RequestMapping(value="city", method=RequestMethod.POST)
	public City postCity(@RequestBody City city) {
		return cheater.createCity(city);
	}
	
	@RequestMapping("city/{id}")
	public City getCity(@PathVariable("id") Long id) {
		return cheater.readCity(id);
	}
	
	@RequestMapping(value="state", method=RequestMethod.POST)
	public State postState(@RequestBody State state) {
		return cheater.createState(state);
	}
	
	@RequestMapping("state/{id}")
	public State getState(@PathVariable("id") Long id) {
		return cheater.readState(id);
	}
	
	@RequestMapping("cities")
	public List<City> getCities() {
		return cheater.readCities();
	}
	
	@RequestMapping("states")
	public List<State> getStates() {
		return cheater.readStates();
	}
	
}
