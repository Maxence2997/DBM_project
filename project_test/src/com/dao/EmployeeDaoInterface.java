package com.dao;

import com.entities.Employee;

public interface EmployeeDaoInterface extends DaoInterface<Employee>
{
	public void createEmployee();
	
	public Employee getEmployee(int id);
}
