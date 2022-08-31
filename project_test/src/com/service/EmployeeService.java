package com.service;

import java.util.UUID;

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
	public void createEmployee(String firstName, String lastName, String address, String phoneNum)
	{
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		
		
		
	}

	@Override
	public void createEmployee(String firstName, String lastName, String optinal, boolean isAddress)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createEmployee(String firstName, String lastName)
	{
		// TODO Auto-generated method stub
		
	}


	
}
