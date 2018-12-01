package org.m2i.metier;

import java.util.List;

import org.m2i.dao.EmployeeRepository;
import org.m2i.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeImplementation implements EmployeMetier{
	@Autowired
	private EmployeeRepository employeeRepository; 

	@Override
	public Employee saveEmploye(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmplyes() {
		return employeeRepository.findAll();
	}

}
