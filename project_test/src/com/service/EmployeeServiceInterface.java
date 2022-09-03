package com.service;

import java.util.Optional;
import com.entities.Employee;

public interface EmployeeServiceInterface
{
	public Optional<Employee> getEmployee(String empId);

	public void createEmployee(String firstName, String lastName, String address, String phoneNum);

	public void createEmployee(String firstName, String lastName, String optinal,
			boolean isAddress);

	public void createEmployee(String firstName, String lastName);
}
