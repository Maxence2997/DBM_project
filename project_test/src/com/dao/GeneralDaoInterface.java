package com.dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

public interface GeneralDaoInterface
{
	// public <T> T findByFields(Class<T> classType, String value)
	// throws NoResultException, NonUniqueResultException;
	public <T> List<T> findByFieldIn(Class<T> classType, String fieldName, List<String> value);

	public <T> List<T> findByFieldLike(Class<T> classType, String fieldName, String value);
}
