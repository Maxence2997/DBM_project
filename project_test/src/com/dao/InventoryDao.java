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
import com.entities.Inventory;
import com.util.EntitiesColumn;

@Repository
public class InventoryDao implements InvDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Deprecated
	public void createOrUpdateInventory(Inventory inventory)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(inventory);
	}

	@Override
	public Inventory getInventory(String inventoryId)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// retrieve/read from database using the primary key
		Inventory inventory = session.get(Inventory.class, inventoryId);
		return inventory;
	}

	@Override
	public void createInventory(Inventory inventory)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.save(inventory);
	}

	@Override
	public void updateInventory(Inventory inventory)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.update(inventory);
	}

//	@Override
//	public List<Inventory> findInventoryByNames(String firstName, String lastName)
//	{
//		List<Inventory> resultList = null;
//		String firstName2 = "%" + firstName + "%";
//		String lastName2 = "%" + lastName + "%";
//
//		try
//		{
//			// get the current hibernate session
//			Session session = sessionFactory.getCurrentSession();
//
//			// retrieve/read from database by query
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Inventory> criteria = builder.createQuery(Inventory.class);
//			Root<Inventory> root = criteria.from(Inventory.class);
//
//			Predicate firstNameLike = builder.like(root.get(EntitiesColumn.FIRST_NAME), firstName2);
//			Predicate lastNameLike = builder.like(root.get(EntitiesColumn.LAST_NAME), lastName2);
//
//			criteria.select(root).where(builder.or(firstNameLike, lastNameLike));
//			// root.get(fieldName): get() should be filled with field name instead of column name
//
//			TypedQuery<Inventory> query = session.createQuery(criteria);
//			resultList = query.getResultList();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		return resultList;
//	}

	@Override
	public void deleteInventory(Inventory inventory)
	{
		Session session = sessionFactory.getCurrentSession();

		session.delete(inventory);
	}

}
