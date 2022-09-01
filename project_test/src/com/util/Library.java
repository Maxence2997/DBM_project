package com.util;

import java.util.UUID;

public class Library implements UuidLibInterface
{
	@Override
	public String prepareUuid()
	{
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString().replaceAll("-", "");
		
		return uuidString;
	}
}
