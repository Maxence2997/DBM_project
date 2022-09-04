package com.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Employee;
import com.util.EntitiesColumn;

@Repository
public class EmployeeDao implements EmpDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Deprecated
	public void createOrUpdateEmployee(Employee employee)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	@Override
	public Employee getEmployee(String empId)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// retrieve/read from database using the primary key
		Employee employee = session.get(Employee.class, empId);
		return employee;
	}

	@Override
	public void createEmployee(Employee employee)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
	}

	@Override
	public List<Employee> findEmployeeByNames(String firstName, String lastName)
	{
		List<Employee> resultList = null;
		String firstName2 = "%" + firstName + "%";
		String lastName2 = "%" + lastName + "%";

		try
		{
			// get the current hibernate session
			Session session = sessionFactory.getCurrentSession();

			// retrieve/read from database by query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> root = criteria.from(Employee.class);

			Predicate firstNameLike = builder.like(root.get(EntitiesColumn.FIRST_NAME), firstName2);
			Predicate lastNameLike = builder.like(root.get(EntitiesColumn.LAST_NAME), lastName2);

			criteria.select(root).where(builder.or(firstNameLike, lastNameLike));
			// root.get(fieldName): get() should be filled with field name instead of column name

			TypedQuery<Employee> query = session.createQuery(criteria);
			resultList = query.getResultList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public void deleteEmployee(Employee employee)
	{
		Session session = sessionFactory.getCurrentSession();

		session.delete(employee);
	}
}
