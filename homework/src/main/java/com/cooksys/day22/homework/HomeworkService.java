package com.cooksys.day22.homework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.day22.homework.model.Student;
import com.cooksys.day22.homework.springview.StudentView;

import tx.DBTXResponse;

@Service
public class HomeworkService {
	
	@Autowired
	StudentRepository studentRepository;

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

}
