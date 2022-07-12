package com.sneha.demo.cruddemo.dao;

import java.util.List;

import com.sneha.demo.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
