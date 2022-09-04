package com.dao;

import java.util.List;

import com.entities.Employee;

public interface EmpDaoInterface
{
	@Deprecated
	public void createOrUpdateEmployee(Employee employee);

	public Employee getEmployee(String id);
	
	public void createEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);

	public List<Employee> findEmployeeByNames(String firstName, String lastName);

	public void deleteEmployee(Employee employee);
}
