package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import com.entities.Employee;

public interface EmpServiceInterface
{
	public Optional<Employee> getEmployee(String empId) throws Exception;

	public List<Employee> getEmployeeByFirstName(String firstName) throws Exception;

	public List<Employee> getEmployeeByLastName(String lastName) throws Exception;
	
	public List<Employee> getEmployeeByNames(String firstName, String lastName) throws Exception;

	public void createEmployee(String firstName, String lastName, String address, String phoneNum,
			String supervisorId, String performance);

	public void createEmployee(String firstName, String lastName);

	public void createEmployee(String firstName, String lastName, String address, String phoneNum,
			Employee supervisor, String performance);

	public void updateEmployee(HashMap<String, Object> empFieldsMap) throws Exception;

	public Employee getSupervisor(String supervisorId);
	
	public void deleteEmployee(String empId) throws Exception;
}
