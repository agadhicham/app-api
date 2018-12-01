package org.m2i.metier;

import java.util.List;

import org.m2i.entities.Employee;

public interface EmployeMetier{
	public Employee saveEmploye(Employee employee);
	public List<Employee> getAllEmplyes();

}
