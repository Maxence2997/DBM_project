package com.dao;

import com.entities.Employee;

public interface EmployeeDaoInterface 
{
	public void createEmployee(Employee employee);
	
	public Employee getEmployee(int id);
}
