package com.dao;

import com.entities.Sheet;

public interface SheetDaoInterface
{
	@Deprecated
	public void createOrUpdateSheet(Sheet sheet);
	
	public Sheet getSheet(String sheetId);
	
	public void createSheet(Sheet sheet);
	
	public void updateSheet(Sheet sheet);
	
	public void deleteSheet(Sheet sheet);
}
