package com.jarvis.app.service.dto;

import java.util.List;

public class StudentDto {

	private Integer id;
	private String fname;
	private String lname;

	public void setId(Integer id) {
		this.id = id;
	}

	
	private List<AddressDto> addresslist;

	

	public Integer getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<AddressDto> getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(List<AddressDto> addresslist) {
		this.addresslist = addresslist;
	}

}
