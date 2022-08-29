package com.service;

import com.entities.Employee;

public interface EmployeeServiceInterface extends ServiceInterface<Employee>
{
	public Employee getEmployee(int id);
	
	public void createEmployee();
}
