package com.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.DefDaoInterface;
//import com.util.EntityIdLibInterface;

@Service
public class DefinitionService implements DefServiceInterface
{
	@Autowired
	private DefDaoInterface definitionDao;
	
//	@Autowired
//	private EntityIdLibInterface entityIdLib;
	
	@Override
	@Transactional
	public Optional<String> getLastKeyId(String paramKey)
	{
		Optional<String> lastKeyId = Optional.empty();
		
		try
		{
			lastKeyId = definitionDao.getLastKeyId(paramKey);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lastKeyId;
	}
}
