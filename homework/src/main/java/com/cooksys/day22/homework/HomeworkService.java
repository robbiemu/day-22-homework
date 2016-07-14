package com.cooksys.day22.homework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.day22.homework.model.City;
import com.cooksys.day22.homework.model.State;
import com.cooksys.day22.homework.model.Student;
import com.cooksys.day22.homework.repository.CityRepository;
import com.cooksys.day22.homework.repository.StateRepository;
import com.cooksys.day22.homework.repository.StudentRepository;
import com.cooksys.day22.homework.springview.StudentView;
import com.cooksys.day22.homework.tx.DBTXResponse;

@Service
public class HomeworkService {
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	StateRepository stateRepository;
	
	public List<StudentView> readStudents() {
		List<Student> students = studentRepository.findAll();
		if(students == null) {
			return null;
		}

		List<StudentView> l = new ArrayList<>();
		for(Student s: students) {
			l.add(new StudentView(s));
		}
		return l;
	}

	public Student readStudent(Long id) {
		return studentRepository.findOne(id);
	}

	public DBTXResponse<StudentView> readStudentsByCity(String city) {
		List<Student> students = studentRepository.findByCity(city);
		if(students == null) {
			return null;
		}
		
		List<StudentView> l = new ArrayList<>();
		for(Student s: students) {
			l.add(new StudentView(s));
		}
		DBTXResponse<StudentView> r = new DBTXResponse<>(city);
		r.setElements(l);

		return r;
	}

	public Student createStudent(Student student) {
		studentRepository.save(student);

		return student;
	}

	public City createCity(City city) {
		cityRepository.save(city);
		return city;
	}

	public State createState(State state) {
		stateRepository.save(state);
		return state;
	}

	public City readCity(Long id) {
		return cityRepository.findOne(id);
	}

	public State readState(Long id) {
		return stateRepository.findOne(id);
	}

	public List<City> readCities() {
		return cityRepository.findAll();
	}

	public List<State> readStates() {
		return stateRepository.findAll();
	}

	public Student createCityofStudent(Long city_id) {
		return (cityRepository.exists(city_id))? studentRepository.saveCity(cityRepository.findOne(city_id)): null;
	}

	public Student createStateofStudent(Long state_id) {
		return (stateRepository.exists(state_id))? studentRepository.saveState(stateRepository.findOne(state_id)): null;
	}
	
}
