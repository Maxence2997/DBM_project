package com.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.EmployeeDao;
import com.dao.GeneralDaoInterface;
import com.entities.Employee;
import com.util.GeneralLibInterface;

@Service
public class EmployeeService implements EmpServiceInterface
{
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private GeneralLibInterface generalLib;

	@Autowired
	private GeneralDaoInterface generalDao;

	@Override
	@Transactional
	public Optional<Employee> getEmployee(String empId)
	{
		Employee employee = null;

		try
		{
			employee = employeeDao.getEmployee(empId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return Optional.ofNullable(employee);
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
		String classShortName = generalLib.getShortNameOfClass(Employee.class);
		String emp_id = generalLib.generateKeyId(classShortName);
		employee.setEmployeeId(emp_id);

		employeeDao.createEmployee(employee);
	}
}
