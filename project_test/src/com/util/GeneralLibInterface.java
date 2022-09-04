package com.util;

import java.time.LocalDateTime;

public interface GeneralLibInterface
{
	@Deprecated
	public String prepareUuid();

	public String generateKeyId(String entityType);

	public <T> String getShortNameOfClass(Class<T> classType);

	public <T> String getCustomKey(Class<T> classType) throws Exception;

	public LocalDateTime getCurrentTimeWithZone(String timeZone);
	
	public <T> int getNumOfColumn(Class<T> entityName);
}
