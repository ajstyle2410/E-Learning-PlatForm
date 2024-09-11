package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee addEmployees(Employee employee);

	List<Employee> viewEmployees();

	String deleteEmployee(long id);

	
}
