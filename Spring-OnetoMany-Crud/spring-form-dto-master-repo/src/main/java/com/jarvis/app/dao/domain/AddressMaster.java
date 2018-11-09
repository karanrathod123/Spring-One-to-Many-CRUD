package com.jarvis.app.dao.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressMaster 
{
	@Id
	@GeneratedValue
	private Integer id;
	private String location;
	private String city;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private StudentMaster studentMaster;
	
	public StudentMaster getStudentMaster() {
		return studentMaster;
	}
	public void setStudentMaster(StudentMaster studentMaster) {
		this.studentMaster = studentMaster;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
