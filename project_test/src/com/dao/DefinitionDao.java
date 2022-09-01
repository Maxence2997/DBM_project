package com.dao;

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
	public String getLastKeyId(String keyName)
	{
		String lastKeyId = null;

		try
		{
			Session session = sessionFactory.getCurrentSession();

			Definition definition = session.get(Definition.class, keyName);

			if (definition != null && definition.getValue() != null)
			{
				lastKeyId = definition.getValue();
			}
			// session.get(): Return the persistent instance of the given named
			// entity with the
			// given identifier, or null if there is no such persistent
			// instance.
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lastKeyId;
	}
}
