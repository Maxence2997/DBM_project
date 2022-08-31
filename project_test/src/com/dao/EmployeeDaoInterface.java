package com.dao;

import com.entities.Employee;

public interface EmployeeDaoInterface extends DaoInterface<Employee>
{
	public void createEmployee(Employee employee);
	
	public Employee getEmployee(int id);
}
