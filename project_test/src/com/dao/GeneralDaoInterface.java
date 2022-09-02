package com.dao;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

public interface GeneralDaoInterface
{
	public <T> T findByCustomKey(Class<T> classType, String value)
			throws NoResultException, NonUniqueResultException;
}
