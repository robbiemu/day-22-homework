package com.cooksys.day22.homework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student extends Model {
	@Column String name;
	@ManyToOne City city;
	@ManyToOne State state;
	
	public Student () { }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

	
}
