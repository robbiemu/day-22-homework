package com.cooksys.day22.homework.springview;

import com.cooksys.day22.homework.model.Student;

public class StudentView {
	Long id;
	String name;
	String city;
	
	public StudentView () { }
	
	public StudentView (Student student) {
		this.name = student.getName();
		this.id = student.getId();
		this.city = student.getCity().getName();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
