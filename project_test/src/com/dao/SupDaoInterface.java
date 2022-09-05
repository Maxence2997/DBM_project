package com.dao;

import com.entities.Supplier;

public interface SupDaoInterface
{
	@Deprecated
	public void createOrUpdateSupplier(Supplier supplier);
	
	public Supplier getSupplier(String supplierId);
	
	public void createSupplier(Supplier supplier);
	
	public void updateSupplier(Supplier supplier);
	
	public void deleteSupplier(Supplier supplier);
}
