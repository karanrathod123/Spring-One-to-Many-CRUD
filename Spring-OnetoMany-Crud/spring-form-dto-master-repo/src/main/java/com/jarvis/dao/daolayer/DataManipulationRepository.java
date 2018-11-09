package com.jarvis.dao.daolayer;

import java.util.List;

import com.jarvis.app.dao.domain.StudentMaster;

public interface DataManipulationRepository {

	public boolean saveStudent(StudentMaster studentMaster);

	public List<StudentMaster> getStudentList();

	public StudentMaster editStudent(Integer id);

	public boolean deleteStudent(StudentMaster transferStudentDtoIdtoStudentMasterId);

}
