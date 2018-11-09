package com.jarvis.app.dao.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentMaster {
	@Id
	@GeneratedValue
	private Integer id;
	private String fname;
	private String lname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentMaster")
	List<AddressMaster> addresslist;

	public List<AddressMaster> getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(List<AddressMaster> addresslist) {
		this.addresslist = addresslist;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
