package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Sheet;

@Repository
public class SheetDao implements SheetDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Deprecated
	public void createOrUpdateSheet(Sheet sheet)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sheet);
	}
	
	@Override
	public Sheet getSheet(String sheetId)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		Sheet sheet = session.get(Sheet.class, sheetId);
		return sheet;
	}
	
	@Override
	public void createSheet(Sheet sheet)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.save(sheet);
	}
	
	@Override
	public void updateSheet(Sheet sheet)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.update(sheet);
	}
	
	@Override
	public void deleteSheet(Sheet sheet)
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(sheet);
	}
}
