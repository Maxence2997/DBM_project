package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.EmpDaoInterface;
import com.dao.GeneralDaoInterface;
import com.entities.Employee;
import com.util.EntitiesColumn;
import com.util.GeneralLibInterface;

@Service
public class EmployeeService implements EmpServiceInterface
{
	@Autowired
	private EmpDaoInterface employeeDao;
	
	@Autowired
	private GeneralLibInterface generalLib;
	
	@Autowired
	private GeneralDaoInterface generalDao;
	
	@Override
	@Transactional
	public Optional<Employee> getEmployee(String empId) throws Exception
	{
		Employee employee = null;
		
		try
		{
			employee = employeeDao.getEmployee(empId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("No found Employee with " + empId);
		}
		return Optional.ofNullable(employee);
	}
	
	@Override
	@Transactional
	public void createEmployee(String firstName, String lastName)
	{
		// get new emp_id from table - definition
		String classShortName = generalLib.getShortNameOfClass(Employee.class);
		String empId = generalLib.generateKeyId(classShortName);
		Employee employee = Employee.of(empId).setFields(firstName, lastName);
		
		employeeDao.createEmployee(employee);
	}
	
	@Override
	@Transactional
	public void createEmployee(String firstName, String lastName, String address, String phoneNum,
			String supervisorId, String performance)
	{
		Employee supervisor = getSupervisor(supervisorId);
		createEmployee(firstName, lastName, address, phoneNum, supervisor, performance);
	}
	
	@Override
	@Transactional
	public void createEmployee(String firstName, String lastName, String address, String phoneNum,
			Employee supervisor, String performance)
	{
		// get new emp_id from table - definition
		String classShortName = generalLib.getShortNameOfClass(Employee.class);
		String empId = generalLib.generateKeyId(classShortName);
		
		Employee employee = Employee.of(empId).setFields(firstName, lastName, address, phoneNum,
				supervisor, performance);
		
		employee.setSupervisor(supervisor);
		
		employeeDao.createEmployee(employee);
	}
	
	@Override
	@Transactional
	public void updateEmployee(Map<String, String> empFieldsMap) throws Exception
	{
		int employeeFieldNum = generalLib.getNumOfColumn(Employee.class);
		
		if (empFieldsMap.size() < employeeFieldNum)
		{
			throw new Exception("there is no enough fields in empFieldsMap, which is required "
					+ employeeFieldNum + " fields.");
		}
		String empId = empFieldsMap.get(EntitiesColumn.EMPLOYEE_ID);
		String firstName = empFieldsMap.get(EntitiesColumn.FIRST_NAME);
		String lastName = empFieldsMap.get(EntitiesColumn.LAST_NAME);
		String address = empFieldsMap.get(EntitiesColumn.ADDRESS);
		String phoneNum = empFieldsMap.get(EntitiesColumn.PHONE_NUM);
		String performance = empFieldsMap.get(EntitiesColumn.PERFORMANCE);
		
		Employee supervisor = Optional.ofNullable(empFieldsMap.get(EntitiesColumn.SUPERVISOR_ID))
				.map(s -> this.getSupervisor(s)).orElseGet(() ->
				{
					return null;
				});
		
		Employee employee = Employee.of(empId).setFields(firstName, lastName, address, phoneNum,
				supervisor, performance);
		
		employeeDao.updateEmployee(employee);
	}
	
	@Override
	@Transactional
	public Employee getSupervisor(String supervisorId)
	{
		Optional<String> supervisorIdOpt = Optional.ofNullable(supervisorId)
				.filter(s -> !s.trim().isEmpty());
		// That will return an empty Optional if supervisorId is null or empty.
		
		Employee supervisor = null;
		
		if (supervisorIdOpt.isPresent())
		{
			
			try
			{
				supervisor = getEmployee(supervisorIdOpt.get()).orElseGet(() ->
				{
					System.out.println("No found for the supervisor ID:" + supervisorId);
					return null;
				});
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return supervisor;
	}
	
	@Override
	@Transactional
	public List<Employee> getEmployeeByFirstName(String firstName) throws Exception
	{
		List<Employee> empList = generalDao.findByFieldLike(Employee.class,
				EntitiesColumn.FIRST_NAME, firstName);
		return empList;
	}
	
	@Override
	@Transactional
	public List<Employee> getEmployeeByLastName(String lastName) throws Exception
	{
		List<Employee> empList = generalDao.findByFieldLike(Employee.class,
				EntitiesColumn.LAST_NAME, lastName);
		return empList;
	}
	
	@Override
	@Transactional
	public List<Employee> getEmployeeByNames(String firstName, String lastName) throws Exception
	{
		List<Employee> empList = employeeDao.findEmployeeByNames(firstName, lastName);
		return empList;
	}
	
	@Override
	@Transactional
	public void deleteEmployee(String empId) throws Exception
	{
		Employee employee = Employee.of(empId);
		employeeDao.deleteEmployee(employee);
	}
}
