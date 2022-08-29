package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.EmployeeDao;
import com.entities.Employee;

@Service
public class EmployeeService implements EmployeeServiceInterface
{
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public Employee getEmployee(int id)
	{
		Employee employee = employeeDao.getEmployee(id);
		
		return employee;
	}

	@Override
	@Transactional
	public void createEmployee()
	{
		// TODO Auto-generated method stub
	}
}
