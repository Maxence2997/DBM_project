package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.EmployeeDao;
import com.entities.Employee;
import com.util.EntityIdLibInterface;

@Service
public class EmployeeService implements EmpServiceInterface
{
	@Autowired
	EmployeeDao employeeDao;
	
	// @Autowired
	// private DefinitionService definitionService;
	
	@Autowired
	private EntityIdLibInterface entityIdLib;
	
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
		String emp_id = entityIdLib.generateKeyId(Employee.class.getName());
		employee.setEmployeeId(emp_id);
		
		// create uuid
		String uuid = entityIdLib.prepareUuid();
		employee.setUuid(uuid);
		
		employeeDao.createEmployee(employee);
	}
}
