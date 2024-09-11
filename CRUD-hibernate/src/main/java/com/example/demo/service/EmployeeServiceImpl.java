package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional // This will ensure proper transaction handling
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Employee addEmployees(Employee employee) {
        return productRepository.saveEmployee(employee);
    }

    @Override
    public List<Employee> viewEmployees() {
        return productRepository.getAllEmployee();
    }

    @Override
    public String deleteEmployee(long id) {
        return productRepository.deleteEmployee(id);
    }
}
