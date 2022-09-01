package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.EmployeeDao;
import com.entities.Employee;
import com.util.UuidLibInterface;

@Service
public class EmployeeService implements EmpServiceInterface
{
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	private DefinitionService definitionService;
	
	@Autowired
	private UuidLibInterface uuidlib;
	
	@Override
	@Transactional
	public Employee getEmployee(int id)
	{
		Employee employee = employeeDao.getEmployee(id);
		
		return employee;
	}
	
	@Override
	@Transactional
	public void createEmployee(String firstName, String lastName)
	{
		createEmployee(firstName, lastName, null, null, null, null);
	}
	
	@Override
	@Transactional
	public void createEmployee(String firstName, String lastName, String address, String phoneNum,
			Employee supervisor, String performance)
	{
		Employee employee = new Employee(firstName, lastName, address, phoneNum, supervisor,
				performance);
		
		// get new emp_id from table - definition
		String emp_id = definitionService.getNewKeyId(Employee.class);
		employee.setEmployeeId(emp_id);
		
		// create uuid
		String uuid = uuidlib.prepareUuid();
		employee.setUuid(uuid);
		
		employeeDao.createEmployee(employee);
	}
}
