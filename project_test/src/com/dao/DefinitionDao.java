package com.dao;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Definition;

@Repository
public class DefinitionDao implements DefDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Optional<String> getLastKeyId(String keyName)
	{
		Optional<String> lastKeyId = Optional.empty();
		
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			Definition definition = session.get(Definition.class, keyName);
			// session.get(): Return the persistent instance of the given named entity with the
			// given identifier, or null if there is no such persistent instance.
			
			lastKeyId = Optional.ofNullable(definition).map(def -> def.getValue());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lastKeyId;
	}
}
