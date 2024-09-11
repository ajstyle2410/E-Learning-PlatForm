package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee addEmployees(Employee employee);

	List<Employee> viewEmployees();

	String deleteEmployee(long id);

	Employee updateEmployee(Employee employee, long id);

	
}
