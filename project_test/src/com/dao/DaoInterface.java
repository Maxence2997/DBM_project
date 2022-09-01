package com.dao;

public abstract interface DaoInterface<T>
{
	//create
	public void create(Class<T> entityClass, T entity);
	
	//read
	public T get(String key);
	
	//update
	public void update(Class<T> entityClass, T entity);
	
	//remove
	public void remove(Class<T> entityClass, String key);
}
