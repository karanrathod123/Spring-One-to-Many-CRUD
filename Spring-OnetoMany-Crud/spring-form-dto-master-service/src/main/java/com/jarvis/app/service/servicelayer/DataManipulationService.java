package com.jarvis.app.service.servicelayer;

import java.util.List;

import com.jarvis.app.service.dto.StudentDto;

public interface DataManipulationService {

	public boolean saveStudent(StudentDto studentDto);

	public List<StudentDto> getStudentList();

	public StudentDto editStudent(Integer id);

	public boolean deleteStudent(Integer id);

	

}
