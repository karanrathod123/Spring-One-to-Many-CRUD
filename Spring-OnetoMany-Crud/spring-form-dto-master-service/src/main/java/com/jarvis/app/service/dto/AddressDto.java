package com.jarvis.app.service.dto;

public class AddressDto 
{

	private Integer id;
	private String location;
	private String city;
	private StudentDto studentDto;				/*studentDto*/
	
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
	public StudentDto getStudentDto() {
		return studentDto;
	}
	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}
}
