package com.dao;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Definition;
import com.entities.Employee;
import com.entities.Examination;
import com.entities.Inventory;
import com.entities.Product;
import com.entities.Project;
import com.entities.Purchase;
import com.entities.Quotation;
import com.entities.Receipt;
import com.entities.Requisition;
import com.entities.Rfq;
import com.entities.Supplier;

@Repository
public class DefinitionDao implements DefDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getLastKeyId(String keyName)
	{
		String lastKeyId = null;
		
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			Definition definition = session.get(Definition.class, keyName);
			
			lastKeyId = definition.getValue();
			// session.get(): Return the persistent instance of the given named entity with the
			// given identifier, or null if there is no such persistent instance.
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lastKeyId;
	}
}
