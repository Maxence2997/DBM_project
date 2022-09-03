package com.service;

import java.util.Optional;
import com.entities.Employee;

public interface EmpServiceInterface
{
	public Optional<Employee> getEmployee(String empId);

	public void createEmployee(String firstName, String lastName, String address, String phoneNum,
			Employee supervisor, String performance);

	public void createEmployee(String firstName, String lastName);
}
