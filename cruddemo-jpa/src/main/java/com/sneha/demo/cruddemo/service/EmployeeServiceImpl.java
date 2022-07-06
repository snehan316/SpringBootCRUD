package com.sneha.demo.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sneha.demo.cruddemo.dao.EmployeeDAO;
import com.sneha.demo.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO dao;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO employeeDAO) {
		dao = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int theId) {
		return dao.getEmployeeById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		dao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		dao.deleteById(theId);
	}

}
