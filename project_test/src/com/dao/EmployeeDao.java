package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Employee;

@Repository
@Transactional
public class EmployeeDao implements EmployeeDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createEmployee()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public Employee getEmployee(int id)
	{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// retrieve/read from database using the primary key
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}
}
