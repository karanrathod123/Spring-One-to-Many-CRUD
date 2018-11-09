package com.jarvis.app.service.transformer;

import java.util.ArrayList;
import java.util.List;

import com.jarvis.app.dao.domain.AddressMaster;
import com.jarvis.app.dao.domain.StudentMaster;
import com.jarvis.app.service.dto.AddressDto;
import com.jarvis.app.service.dto.StudentDto;

public class StudentTransformer {

	public static StudentMaster transferStudentDtoToMaster(StudentDto studentDto) {
		StudentMaster studentMaster = new StudentMaster();
		if (studentDto.getId() != null)
			studentMaster.setId(studentDto.getId());
		studentMaster.setFname(studentDto.getFname());
		studentMaster.setLname(studentDto.getLname());

		List<AddressDto> addressDtos = studentDto.getAddresslist();
		List<AddressMaster> addressMasters = new ArrayList<AddressMaster>();
		for (AddressDto addressDto : addressDtos) {
			AddressMaster addressMaster = new AddressMaster();
			if (addressDto.getId() != null)
				addressMaster.setId(addressDto.getId());

			addressMaster.setLocation(addressDto.getLocation());
			addressMaster.setCity(addressDto.getCity());
			addressMaster.setStudentMaster(studentMaster);

			addressMasters.add(addressMaster);

		}
		studentMaster.setAddresslist(addressMasters);
		return studentMaster;

	}

	public static StudentDto transferStudentMasterToDto(StudentMaster studentMaster) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(studentMaster.getId());
		studentDto.setFname(studentMaster.getFname());
		studentDto.setLname(studentMaster.getLname());

		List<AddressDto> adDtos = new ArrayList<AddressDto>();
		List<AddressMaster> addressMasters = studentMaster.getAddresslist();
		for (AddressMaster addressMaster : addressMasters) {
			AddressDto addressDto = new AddressDto();
			addressDto.setId(addressMaster.getId());
			addressDto.setLocation(addressMaster.getLocation());
			addressDto.setCity(addressMaster.getCity());
			addressDto.setStudentDto(studentDto);
			adDtos.add(addressDto);

		}
		studentDto.setAddresslist(adDtos);

		return studentDto;

	}

	public static StudentMaster transferStudentDtoIdtoStudentMasterId(Integer id) {
		StudentMaster studentMaster = new StudentMaster();
		if (id != null)
			studentMaster.setId(id);
		return studentMaster;
		
	}

}
