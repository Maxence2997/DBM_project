package com.dao;

import java.util.List;

import com.entities.Inventory;

public interface InvDaoInterface
{
	@Deprecated
	public void createOrUpdateInventory(Inventory inventory);

	public Inventory getInventory(String id);
	
	public void createInventory(Inventory inventory);
	
	public void updateInventory(Inventory inventory);

//	public List<Inventory> findInventoryByNames(String firstName, String lastName);

	public void deleteInventory(Inventory inventory);
}
