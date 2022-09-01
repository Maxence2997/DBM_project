package com.service;

import com.entities.Employee;

public interface EmpServiceInterface
{
	public Employee getEmployee(int id);
	
	public void createEmployee(String firstName, String lastName, String address, String phoneNum,
			Employee supervisor, String performance);
	
	public void createEmployee(String firstName, String lastName);
}
