package com.entities;

import java.time.LocalDate;

public abstract class Sheet
{
	protected int sheetId;
	protected String sheetType;
	protected int proejctId;
	protected int supplierId;
	protected int moduleId;
	protected int volume;
	protected LocalDate date;
	
	protected abstract Sheet getSheet();
	
}
