package com.jrm.springboot.crud.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.jrm.springboot.crud.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	
	
}
