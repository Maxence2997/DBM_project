package com.dao;

import com.entities.Product;

public interface ProdDaoInterface
{
	@Deprecated
	public void createOrUpdateProduct(Product product);
	
	public Product getProduct(String productId);
	
	public void createProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);
}
