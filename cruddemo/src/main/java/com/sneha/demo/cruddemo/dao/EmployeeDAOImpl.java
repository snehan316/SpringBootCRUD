package com.sneha.demo.cruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sneha.demo.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager){
		this.entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
	
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
 	}

	@Override
	public Employee getEmployeeById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}
