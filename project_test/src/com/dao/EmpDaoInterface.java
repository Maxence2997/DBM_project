package com.dao;

import com.entities.Employee;

public interface EmpDaoInterface
{
	public void createEmployee(Employee employee);

	public Employee getEmployee(String id);
}
