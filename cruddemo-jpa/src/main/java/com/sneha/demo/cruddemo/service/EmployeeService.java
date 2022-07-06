package com.sneha.demo.cruddemo.service;

import java.util.List;

import com.sneha.demo.cruddemo.entity.Employee;

public interface EmployeeService {

public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
