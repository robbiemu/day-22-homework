package com.cooksys.day22.homework.springview;

import com.cooksys.day22.homework.model.Student;

public class StudentView {
	Long id;
	String name;
	
	public StudentView () { }
	
	public StudentView (Student student) {
		this.name = student.getName();
		this.id = student.getId();
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
	
}
