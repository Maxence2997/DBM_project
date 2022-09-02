package com.util;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.service.DefServiceInterface;

@Repository
public class GeneralLibrary implements GeneralLibInterface
{
	@Value("#{paramKeyMap}")
	private HashMap<String, String> paramKeyMap;

	@Value("#{entityInitValueMap}")
	private HashMap<String, String> initValueMap;

	@Value("#{customKeyMap}")
	private HashMap<String, String> customKeyMap;

	@Autowired
	private DefServiceInterface definitionService;

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

			if (!paramKeyMap.containsKey(entityType))
			{
				// throw exception
				throw new Exception("There is no " + entityType + " in the entityKeyMap.");
			}
			else
			{
				String paramKey = paramKeyMap.get(entityType);

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

	@Override
	public <T> String getShortNameOfClass(Class<T> classType)
	{
		String className = classType.getName();
		int lastIdxOfPoint = className.lastIndexOf(".");

		return className.substring(lastIdxOfPoint + 1);
	}

	@Override
	public <T> String getCustomKey(Class<T> classType) throws Exception
	{
		String className = getShortNameOfClass(classType);
		Optional<String> container = Optional.ofNullable(customKeyMap.get(className));
		
		return container.orElseThrow(() -> new Exception(
				"There is no custom key in customKeyMap for mapping Class/Entity: "
						+ classType.getName()));
	}
}
