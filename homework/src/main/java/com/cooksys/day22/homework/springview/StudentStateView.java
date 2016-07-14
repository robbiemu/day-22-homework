package com.cooksys.day22.homework.springview;

import com.cooksys.day22.homework.model.Student;

public class StudentStateView {
	Long id;
	String name;
	String state;
	
	public StudentStateView () { }
	
	public StudentStateView (Student student) {
		this.name = student.getName();
		this.id = student.getId();
		this.state = student.getCity().getState().getName();
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
