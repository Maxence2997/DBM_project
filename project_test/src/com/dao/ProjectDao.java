package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entities.Project;

@Repository
public class ProjectDao implements ProjDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Deprecated
	public void createOrUpdateProject(Project project)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(project);
	}
	
	@Override
	public Project getProject(String projectId)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		Project project = session.get(Project.class, projectId);
		return project;
	}
	
	@Override
	public void createProject(Project project)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.save(project);
	}
	
	@Override
	public void updateProject(Project project)
	{
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.update(project);
	}
	
	@Override
	public void deleteProject(Project project)
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(project);
	}
}
