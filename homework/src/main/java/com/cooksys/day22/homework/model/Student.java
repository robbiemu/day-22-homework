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
	
}
