package com.example.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;

@Repository
@Transactional
public class ProductRepository {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Employee> getAllEmployee() {
		return getSession().createQuery("from Employee", Employee.class).list();
	}

	public String deleteEmployee(long id) {
		try {

			Employee employee = getSession().get(Employee.class, id);

			getSession().delete(employee);
			return "delete";
		} catch (Exception e) {
			return "not deleted";
		}
	}

	public Employee saveEmployee(Employee employee) {

		getSession().save(employee);

		return employee;
	}
}
