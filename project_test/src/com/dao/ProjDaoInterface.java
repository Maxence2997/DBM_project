package com.dao;

import com.entities.Project;

public interface ProjDaoInterface
{
	@Deprecated
	public void createOrUpdateProject(Project project);
	
	public Project getProject(String projId);
	
	public void createProject(Project project);
	
	public void updateProject(Project project);
	
	public void deleteProject(Project project);
}
