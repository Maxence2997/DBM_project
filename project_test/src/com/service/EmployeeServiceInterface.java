package com.service;

import com.entities.Employee;

public interface EmployeeServiceInterface extends ServiceInterface<Employee>
{
	public Employee getEmployee(int id);

	public void createEmployee(String firstName, String lastName, String address, String phoneNum);

	public void createEmployee(String firstName, String lastName, String optinal, boolean isAddress);

	public void createEmployee(String firstName, String lastName);
}
