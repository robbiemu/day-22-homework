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
import com.cooksys.day22.homework.springview.StudentCityView;
import com.cooksys.day22.homework.springview.StudentStateView;
import com.cooksys.day22.homework.tx.DBTXResponse;

@Service
public class HomeworkService {
	
	@Autowired
	CityRepository cityRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	StudentRepository studentRepository;

	
	public List<Student> readStudents() {
		return studentRepository.findAll();
	}

	public Student readStudent(Long id) {
		return studentRepository.findOne(id);
	}

	public DBTXResponse<StudentStateView> readStudentsByCity(String name) {
		List<Student> students = studentRepository.findByCity(cityRepository.findOneByName(name));
		if(students == null) {
			return null;
		}
		
		List<StudentStateView> l = new ArrayList<>();
		for(Student s: students) {
			l.add(new StudentStateView(s));
		}
		DBTXResponse<StudentStateView> r = new DBTXResponse<>(name);
		r.setElements(l);

		return r;
	}
	
	public DBTXResponse<StudentCityView> readStudentsByState(String name) {
		List<Student> students = studentRepository.findByCityStateName(name);
		
		if(students == null) {
			return null;
		}
		
		List<StudentCityView> l = new ArrayList<>();
		for(Student s: students) {
			l.add(new StudentCityView(s));
		}
		DBTXResponse<StudentCityView> r = new DBTXResponse<>(name);
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

	public Student createCityofStudent(Long student_id, Long city_id) {
		Student s = studentRepository.findOne(student_id);
		City c = cityRepository.findOne(city_id);

		s.setCity(c);
	
		studentRepository.save(s);
		
		return s;
	}
	
}
