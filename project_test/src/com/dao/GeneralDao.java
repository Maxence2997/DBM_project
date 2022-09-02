package com.dao;

import java.util.Optional;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.util.GeneralLibInterface;

@Repository
public class GeneralDao implements GeneralDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private GeneralLibInterface generalLib;

	@Override
	public <T> T findByCustomKey(Class<T> classType, String value)
			throws NoResultException, NonUniqueResultException
	{
		Optional<T> returnOptional = Optional.empty();

		try
		{
			String customKey = generalLib.getCustomKey(classType);

			// get the current hibernate session
			Session session = sessionFactory.getCurrentSession();

			// retrieve/read from database by query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(classType);
			Root<T> root = criteria.from(classType);
			criteria.select(root).where(builder.equal(root.get(customKey), value));
			// root.get(fieldName): get() should be filled with field name instead of column name
			TypedQuery<T> query = session.createQuery(criteria);
			returnOptional = Optional.ofNullable(query.getSingleResult());
		}catch (NoResultException nre)
		{
			throw new NoResultException();
		}
		catch (NonUniqueResultException nure)
		{
			throw new NonUniqueResultException();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return returnOptional.orElse(null);
	}
}
