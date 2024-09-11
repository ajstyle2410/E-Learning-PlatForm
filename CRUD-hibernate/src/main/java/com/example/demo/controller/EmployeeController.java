package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping("addEmployee")
	public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee)
	{
		
		employeeService.addEmployees(employee);
				
		return  new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("viewemployee")
	public ResponseEntity< List<Employee>>  viewEmployee()
	{
		List<Employee> list = employeeService.viewEmployees();
		return  new ResponseEntity<List<Employee>>(list, HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		  String msg = employeeService.deleteEmployee(id);
		  
		  return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PutMapping("updateemployee/{id}")
	 public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ,@PathVariable("id") long id)
	 {
		
		
		Employee emp = employeeService.updateEmployee(employee,id);
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
		
	 }
	
} 
