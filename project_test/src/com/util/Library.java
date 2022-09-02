package com.util;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.service.DefinitionService;

@Repository
public class Library implements EntityIdLibInterface
{
	@Value("#{entityKeyMap}")
	private HashMap<String, String> entityKeyMap;
	
	@Value("#{entityInitValueMap}")
	private HashMap<String, String> initValueMap;
	
	@Autowired
	private DefinitionService definitionService;
	
	@Override
	public String prepareUuid()
	{
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString().replaceAll("-", "");
		
		return uuidString;
	}
	
	private String generateKeyIdByLastKeyId(String lastKeyId)
	{
		String prefix = lastKeyId.substring(0, 2);
		String serial = lastKeyId.substring(2);
		int serialNum = Integer.valueOf(serial);
		String newId = prefix + String.format("%06d", ++serialNum);
		
		return newId;
	}
	
	@Override
	public String generateKeyId(String entityType)
	{
		Optional<String> lastKeyId = Optional.empty();
		String newKeyId = null;
		
		try
		{
			
			if (!entityKeyMap.containsKey(entityType))
			{
				// throw exception
				throw new Exception("There is no" + entityType + " in the entityKeyMap.");
			}
			else
			{
				String paramKey = entityKeyMap.get(entityType);
				
				lastKeyId = definitionService.getLastKeyId(paramKey);
				newKeyId = lastKeyId.map(s -> this.generateKeyIdByLastKeyId(s))
									.orElseGet(() -> this.initValueMap.get(entityType));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newKeyId;
	}
}
