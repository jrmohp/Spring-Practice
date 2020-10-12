package com.jrm.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrm.springboot.crud.dao.EmployeeDAO;
import com.jrm.springboot.crud.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeRestController(EmployeeDAO thEmployeeDAO) {
		employeeDAO=thEmployeeDAO;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeDAO.finAll();
	}
	
	@GetMapping("/employees/{empid}")
	public Employee findbyid(@PathVariable int empid){
		
		return employeeDAO.findByID(empid);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee thEmployee) {
		
		thEmployee.setId(0);
		return employeeDAO.save(thEmployee);
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee thEmployee)
	{
		return employeeDAO.save(thEmployee);
	}
	
	@DeleteMapping
	public String deleteEmployee(@RequestBody int theId)
	{
		employeeDAO.deleteByID(theId);
		return "deleted emp with id: "+theId;
	}
}
