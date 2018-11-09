package com.jarvis.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jarvis.app.service.dto.AddressDto;
import com.jarvis.app.service.dto.StudentDto;
import com.jarvis.app.service.servicelayer.DataManipulationService;

@Controller
public class DataManipulationController {

	@Autowired
	DataManipulationService dataManipulationService;

	@RequestMapping("index")
	public String viewRegister(Model model) 
	{
		StudentDto studentDto = new StudentDto();

		AddressDto addressDto1 = new AddressDto();
		AddressDto addressDto2 = new AddressDto();

		List<AddressDto> addressDtos = new ArrayList<AddressDto>();
		addressDtos.add(addressDto1);
		addressDtos.add(addressDto2);

		studentDto.setAddresslist(addressDtos);
		model.addAttribute("studentForm", studentDto);

		return "registration";

	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String saveStudent(Model model, @ModelAttribute("studentForm") StudentDto studentDto) {

		boolean bx = dataManipulationService.saveStudent(studentDto);

		return "redirect:index";

	}

	@ModelAttribute("studentList")
	public List<StudentDto> getStudentList() {
		return dataManipulationService.getStudentList();

	}

	@RequestMapping(value = "edit")
	public String editStudent(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("studentForm", dataManipulationService.editStudent(id));

		return "registration";

	}

	@RequestMapping(value = "delete")
	public String deleteStudent(Model model, @RequestParam("id") Integer id) 
	{
		model.addAttribute("studentForm", dataManipulationService.deleteStudent(id));
		return "redirect:index";

	}
}
