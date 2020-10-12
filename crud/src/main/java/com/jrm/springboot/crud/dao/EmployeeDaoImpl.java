package com.jrm.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jrm.springboot.crud.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager thEntityManager) {
		entityManager = thEntityManager;
	}

	@Override
	public List<Employee> finAll() {
		// get current hibernate sesson
		/*
		 * Session currentSession = entityManager.unwrap(Session.class);
		 * 
		 * //reate query Query<Employee> theQuery =
		 * currentSession.createQuery("from Employee",Employee.class);
		 * 
		 * List<Employee> employees = theQuery.getResultList();
		 */

		Query theQuery = entityManager.createQuery("from Employee");

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findByID(int theID) {
		
		/*Session currentSession = entityManager.unwrap(Session.class);
		
		//reate query
		
		 * Employee thEmployee = currentSession.get(Employee.class,theID);
		 * 
		 * 
		 * return thEmployee;
		 */
		
		Employee theEmployee = entityManager.find(Employee.class, theID);
		
		return theEmployee;
		
	}

	@Transactional
	@Override
	public Employee save(Employee thEmployee) {

		/*
		 * Session currentSession = entityManager.unwrap(Session.class);
		 * 
		 * // save currentSession.saveOrUpdate(thEmployee);
		 */
		
		Employee dbEmployee = entityManager.merge(thEmployee);
		
		thEmployee.setId(dbEmployee.getId());
		
		return thEmployee;
	}

	@Override
	public void deleteByID(int theID) {
		// TODO Auto-generated method stub

		/*
		 * Session currentSession = entityManager.unwrap(Session.class);
		 * 
		 * // reate query
		 * 
		 * Employee thEmployee = currentSession.get(Employee.class, theID);
		 * 
		 * currentSession.delete(thEmployee);
		 */
		
		Employee theEmployee = entityManager.find(Employee.class, theID);
		
		entityManager.remove(theEmployee);
		

	}

}
