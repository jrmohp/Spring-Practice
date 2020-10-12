package com.jrm.springboot.crud.dao;

import java.util.List;

import com.jrm.springboot.crud.entity.Employee;

public interface EmployeeDAO {

	
	public List<Employee> finAll();
	public Employee findByID(int theID);
	public Employee save(Employee thEmployee);
	public void deleteByID(int theID);
}
