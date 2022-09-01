package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Employee;

@Repository
public class EmployeeDao implements EmpDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createEmployee(Employee employee)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}
	
	@Override
	public Employee getEmployee(int id)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		Employee employee = session.get(Employee.class, id);
		return employee;
	}
}
