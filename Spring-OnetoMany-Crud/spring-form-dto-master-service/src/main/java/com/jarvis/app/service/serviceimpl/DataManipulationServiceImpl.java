package com.jarvis.app.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jarvis.app.dao.domain.StudentMaster;
import com.jarvis.app.service.dto.StudentDto;
import com.jarvis.app.service.servicelayer.DataManipulationService;
import com.jarvis.app.service.transformer.StudentTransformer;
import com.jarvis.dao.daolayer.DataManipulationRepository;

public class DataManipulationServiceImpl implements DataManipulationService {

	@Autowired
	DataManipulationRepository dataManipulationRepository;

	public boolean saveStudent(StudentDto studentDto) {

		return dataManipulationRepository.saveStudent(StudentTransformer.transferStudentDtoToMaster(studentDto));
	}

	public List<StudentDto> getStudentList() {
		List<StudentDto> stList = new ArrayList<StudentDto>();
		List<StudentMaster> studentMasterList = dataManipulationRepository.getStudentList();
		for (StudentMaster studentMaster : studentMasterList) {
			stList.add(StudentTransformer.transferStudentMasterToDto(studentMaster));
		}

		return stList;

	}

	public StudentDto editStudent(Integer id) {

		StudentMaster studentMaster = dataManipulationRepository.editStudent(id);
		StudentDto studentDto = StudentTransformer.transferStudentMasterToDto(studentMaster);

		return studentDto;
	}

	public boolean deleteStudent(Integer id) {

		return dataManipulationRepository.deleteStudent(StudentTransformer.transferStudentDtoIdtoStudentMasterId(id));
	}

}
