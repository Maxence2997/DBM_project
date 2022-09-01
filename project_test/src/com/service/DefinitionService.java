package com.service;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.DefDaoInterface;
import com.entities.*;

@Service
public class DefinitionService implements DefServiceInterface
{
	@Autowired
	private DefDaoInterface definitionDao;
	
	private HashMap<String, String> entityKeyMap;
	
	private HashMap<String, String> initValueMap;
	
	@PostConstruct
	private void init()
	{
		setEntityKeyMap();
		setInitValueMap();
	}
	
	@Override
	public <T> String getNewKeyId(Class<T> classType)
	{
		String className = classType.getName();
		String newKeyId = null;
		
		try
		{
			
			if (!entityKeyMap.containsKey(className))
			{
				// throw exception
				throw new Exception(
						"There is no" + className + " in the definition table hashMap.");
			}
			else
			{
				String keyString = entityKeyMap.get(className);
				String lastKeyId = definitionDao.getLastKeyId(keyString);
				
				if (lastKeyId == null || lastKeyId.trim().isEmpty())
				{
					newKeyId = initValueMap.get(className);
				}
				else
				{
					newKeyId = produceNewKeyId(lastKeyId);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newKeyId;
	}
	
	private void setEntityKeyMap()
	{
		entityKeyMap = new HashMap<String, String>();
		entityKeyMap.put(Employee.class.getName(), "emp_id");
		entityKeyMap.put(Supplier.class.getName(), "sup_id");
		entityKeyMap.put(Product.class.getName(), "prod_id");
		entityKeyMap.put(Inventory.class.getName(), "inv_id");
		entityKeyMap.put(Project.class.getName(), "proj_id");
//		entityKeyMap.put(Rfq.class.getName(), "rfq_id");
//		entityKeyMap.put(Quotation.class.getName(), "quot_id");
//		entityKeyMap.put(Purchase.class.getName(), "pur_id");
//		entityKeyMap.put(Requisition.class.getName(), "req_id");
//		entityKeyMap.put(Examination.class.getName(), "exam_id");
//		entityKeyMap.put(Receipt.class.getName(), "rec_id");
	}
	
	private void setInitValueMap()
	{
		initValueMap = new HashMap<String, String>();
		initValueMap.put(Employee.class.getName(), "EP000001");
		initValueMap.put(Supplier.class.getName(), "SP000001");
		initValueMap.put(Product.class.getName(), "PD000001");
		initValueMap.put(Inventory.class.getName(), "IV000001");
		initValueMap.put(Project.class.getName(), "PJ000001");
//		initValueMap.put(Rfq.class.getName(), "RF000001");
//		initValueMap.put(Quotation.class.getName(), "QU000001");
//		initValueMap.put(Purchase.class.getName(), "PU000001");
//		initValueMap.put(Requisition.class.getName(), "RE000001");
//		initValueMap.put(Examination.class.getName(), "EX000001");
//		initValueMap.put(Receipt.class.getName(), "RC000001");
	}
	
	private String produceNewKeyId(String lastKeyId)
	{
		String prefix = lastKeyId.substring(0, 2);
		String serial = lastKeyId.substring(2);
		int serialNum = Integer.valueOf(serial);
		String newId = prefix + String.format("%06d", ++serialNum);
		
		return newId;
	}
}
