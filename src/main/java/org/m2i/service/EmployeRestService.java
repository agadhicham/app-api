package org.m2i.service;

import java.util.List;

import org.m2i.entities.Employee;
import org.m2i.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService {
	@Autowired
	private EmployeMetier employeMetier;

	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employee saveEmploye(@RequestBody Employee employee) {
		return employeMetier.saveEmploye(employee);
	}

	@RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employee> getAllEmplyes() {
		return employeMetier.getAllEmplyes();
	}
	

}
