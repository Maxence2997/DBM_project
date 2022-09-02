package com.util;

public interface GeneralLibInterface
{
	public String prepareUuid();

	public String generateKeyId(String entityType);

	public <T> String getShortNameOfClass(Class<T> classType);
	
	public <T> String getCustomKey(Class<T> classType) throws Exception;
}
