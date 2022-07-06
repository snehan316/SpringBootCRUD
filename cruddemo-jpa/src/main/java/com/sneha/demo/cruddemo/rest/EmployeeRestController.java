package com.sneha.demo.cruddemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.demo.cruddemo.entity.Employee;
import com.sneha.demo.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;
	
	public EmployeeRestController() {
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeByID(@PathVariable int employeeId) {
		Employee theEmployee = service.getEmployeeById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found " + employeeId);
		}
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		service.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		service.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = service.getEmployeeById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found " + employeeId);
		}
		
		service.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
	
	
}
