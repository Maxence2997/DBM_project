package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Product;

@Repository
public class ProductDao implements ProdDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Deprecated
	public void createOrUpdateProduct(Product product)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	
	@Override
	public Product getProduct(String productId)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		Product product = session.get(Product.class, productId);
		return product;
	}
	
	@Override
	public void createProduct(Product product)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}
	
	@Override
	public void updateProduct(Product product)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}
	
	@Override
	public void deleteProduct(Product product)
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(product);
	}
}
