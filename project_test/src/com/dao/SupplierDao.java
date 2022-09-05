package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Supplier;

@Repository
public class SupplierDao implements SupDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Deprecated
	public void createOrUpdateSupplier(Supplier supplier)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}
	
	@Override
	public Supplier getSupplier(String supplierId)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		Supplier supplier = session.get(Supplier.class, supplierId);
		return supplier;
	}
	
	@Override
	public void createSupplier(Supplier supplier)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.save(supplier);
	}
	
	@Override
	public void updateSupplier(Supplier supplier)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.update(supplier);
	}
	
	@Override
	public void deleteSupplier(Supplier supplier)
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(supplier);
	}
}
